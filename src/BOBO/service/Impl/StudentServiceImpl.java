package BOBO.service.Impl;

import BOBO.dao.StudentDao;
import BOBO.dao.impl.StudentDaoImpl;
import BOBO.pojo.Page;
import BOBO.pojo.Student;
import BOBO.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(Integer sno) {
        studentDao.deleteStudent(sno);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public Student queryStudentbyId(Integer sno) {
        return studentDao.queryStudentbyId(sno);
    }

    @Override
    public List<Student> queryStudents() {
        return studentDao.queryStudents();
    }

    @Override
    public Page<Student> page(int pageNo, int pageSize) {

        Page<Student> page = new Page<Student>();

        //设置每页的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = studentDao.queryForTotalCount();
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pagetotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pagetotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pagetotal);
        //设置当前页码
        page.setPageNo(pageNo);

        //获取当前页的数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Student> items = studentDao.queryForPageItems(begin, pageSize);
        /*放进items对象中，进行返回*/
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Student> findOneByName(int pageNo, int pageSize, String sname) {

        Page<Student> page = new Page<Student>();

        if (sname.length() == 0) {
            sname = "null";
        } else {
            sname = "%" + sname + "%";
        }
        //设置每页的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = studentDao.queryForTotalCountByName(sname);
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pagetotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pagetotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pagetotal);
        //设置当前页码
        page.setPageNo(pageNo);

        List<Student> items = studentDao.queryByName(sname);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Student> findOneByNo(int pageNo, int pageSize, Integer sno) {
        Page<Student> page = new Page<Student>();

        //设置每页的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = studentDao.queryForTotalCountByNo(sno);
        //设置记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pagetotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pagetotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pagetotal);
        //设置当前页码
        page.setPageNo(pageNo);

        List<Student> items = studentDao.queryByNo(sno);

        page.setItems(items);

        return page;
    }

}
