package BOBO.service.Impl;

import BOBO.dao.TeacherDao;
import BOBO.dao.impl.TeacherDaoImpl;
import BOBO.pojo.Page;
import BOBO.pojo.Teacher;
import BOBO.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherDao teacherDao = new TeacherDaoImpl();

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Integer tno) {
        teacherDao.deleteTeacher(tno);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher queryTeacherbyId(Integer tno) {
        return teacherDao.queryTeacherbyId(tno);
    }

    @Override
    public List<Teacher> queryTeachers() {
        return teacherDao.queryTeachers();
    }

    @Override
    public Page<Teacher> page(int pageNo, int pageSize) {
        Page<Teacher> page = new Page<Teacher>();

        //设置每页的条数
        page.setPageSize(pageSize);
        //记录总记录数
        Integer totalCount = teacherDao.queryForTotalCount();
        //设置总记录数
        page.setPageTotalCount(totalCount);
        //求总页码数
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);

        //获取当前页码数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Teacher> items = teacherDao.queryForPageItems(begin, pageSize);
        //放到ietms属性中，后面方便调用
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Teacher> findOneByNo(int pageNo, int pageSize, Integer tno) {
        Page<Teacher> page = new Page<Teacher>();

        //设置每页的条数
        page.setPageSize(pageSize);
        //记录总记录数
        Integer totalCount = teacherDao.queryForTotalCountByNo(tno);
        //设置总记录数
        page.setPageTotalCount(totalCount);
        //求总页码数
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);

        //获取当前页码数据
        List<Teacher> items = teacherDao.queryByNo(tno);
        //放到ietms属性中，后面方便调用
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Teacher> findOneByName(int pageNo, int pageSize, String tname) {
        Page<Teacher> page = new Page<Teacher>();

        if (tname.length() == 0) {
            tname = "null";
        } else {
            tname = "%" + tname + "%";
        }

        //设置每页的条数
        page.setPageSize(pageSize);
        //记录总记录数
        Integer totalCount = teacherDao.queryForTotalCountByName(tname);
        //设置总记录数
        page.setPageTotalCount(totalCount);
        //求总页码数
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);

        //获取当前页码数据
        List<Teacher> items = teacherDao.queryByName(tname);
        //放到ietms属性中，后面方便调用
        page.setItems(items);

        return page;
    }
}
