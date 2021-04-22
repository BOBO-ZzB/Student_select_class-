package BOBO.dao.impl;

import BOBO.dao.CourseDao;
import BOBO.pojo.Course;

import java.util.List;

public class CourseDaoImpl extends BaseDao implements CourseDao {

    @Override
    public int addCourse(Course course) {
        String sql = "insert into course value(?,?,?,?)";
        return update(sql, course.getCno(), course.getCname(), course.getCpno(), course.getCcredit());
    }

    @Override
    public int deleteCourse(Integer cno) {
        String sql = "delete from course where cno=?";
        return update(sql, cno);
    }

    @Override
    public int updateCourse(Course course) {
        String sql = "update course set cname=?,cpno=?,ccredit=? where cno=?";
        return update(sql, course.getCname(), course.getCpno(), course.getCcredit(), course.getCno());
    }

    @Override
    public Course queryCoursebyId(Integer cno) {
        String sql = "select * from course where cno=?";
        return queryForone(Course.class, sql, cno);
    }

    @Override
    public List<Course> queryCourses() {
        String sql = "select * from course";
        return queryForlist(Course.class, sql);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(1) from course";
        Number count = (Number) queryForsingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Course> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from course limit ?,?";
        return queryForlist(Course.class, sql, begin, pageSize);
    }

    @Override
    public List<Course> queryByName(String name) {
        String sql = "select * from course where cname like ?";
        return queryForlist(Course.class, sql, name);
    }

    @Override
    public List<Course> queryByNo(Integer cno) {
        String sql = "select * from course where cno = ?";
        return queryForlist(Course.class, sql, cno);
    }

    @Override
    public Integer queryForTotalCountByNo(Integer cno) {
        String sql = "select count(1) from course where cno = ?";
        Number count = (Number) queryForsingleValue(sql, cno);
        return count.intValue();
    }

    @Override
    public Integer queryForTotalCountByName(String cname) {
        String sql = "select count(1) from course where cname like ?";
        Number count = (Number) queryForsingleValue(sql, cname);
        return count.intValue();
    }
}
