package BOBO.service.Impl;

import BOBO.dao.CourseDao;
import BOBO.dao.impl.CourseDaoImpl;
import BOBO.pojo.Course;
import BOBO.pojo.Page;
import BOBO.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public void deleteCourse(Integer cno) {
        courseDao.deleteCourse(cno);
    }

    @Override
    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public Course queryCoursebyId(Integer cno) {
        return courseDao.queryCoursebyId(cno);
    }

    @Override
    public List<Course> queryCourses() {
        return courseDao.queryCourses();
    }

    @Override
    public Page<Course> page(int pageNo, int pageSize) {
        Page<Course> page = new Page<Course>();

        page.setPageSize(pageSize);

        Integer totalCount = courseDao.queryForTotalCount();

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;

        List<Course> items = courseDao.queryForPageItems(begin, pageSize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Course> findOneByNo(int pageNo, int pageSize, Integer cno) {
        Page<Course> page = new Page<Course>();

        page.setPageSize(pageSize);

        Integer totalCount = courseDao.queryForTotalCountByNo(cno);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Course> items = courseDao.queryByNo(cno);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Course> findOneByName(int pageNo, int pageSize, String cname) {
        Page<Course> page = new Page<Course>();

        if (cname.length() == 0) {
            cname = "null";
        } else {
            cname = "%" + cname + "%";
        }

        page.setPageSize(pageSize);

        Integer totalCount = courseDao.queryForTotalCountByName(cname);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Course> items = courseDao.queryByName(cname);

        page.setItems(items);

        return page;
    }
}
