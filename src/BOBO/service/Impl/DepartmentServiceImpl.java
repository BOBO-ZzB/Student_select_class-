package BOBO.service.Impl;

import BOBO.dao.DepartmentDao;
import BOBO.dao.impl.DepartmentDaoImpl;
import BOBO.pojo.Course;
import BOBO.pojo.Department;
import BOBO.pojo.Page;
import BOBO.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer dno) {
        departmentDao.deleteDepartment(dno);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    @Override
    public Department queryDepartmentbyId(Integer dno) {
        return departmentDao.queryDepartmentbyId(dno);
    }

    @Override
    public List<Department> queryDepartments() {
        return departmentDao.queryDepartments();
    }


    @Override
    public Page<Department> page(int pageNo, int pageSize) {
        Page<Department> page = new Page<Department>();

        page.setPageSize(pageSize);

        Integer totalCount = departmentDao.queryForTotalCount();

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;

        List<Department> items = departmentDao.queryForPageItems(begin, pageSize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Department> findOneByNo(int pageNo, int pageSize, Integer dno) {
        Page<Department> page = new Page<Department>();

        page.setPageSize(pageSize);

        Integer totalCount = departmentDao.queryForTotalCountByNo(dno);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Department> items = departmentDao.queryByNo(dno);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Department> findOneByName(int pageNo, int pageSize, String dname) {
        Page<Department> page = new Page<Department>();

        if (dname.length() == 0) {
            dname = "null";
        } else {
            dname = "%" + dname + "%";
        }

        page.setPageSize(pageSize);

        Integer totalCount = departmentDao.queryForTotalCountByName(dname);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Department> items = departmentDao.queryByName(dname);

        page.setItems(items);

        return page;
    }
}
