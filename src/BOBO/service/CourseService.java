package BOBO.service;

import BOBO.pojo.Course;
import BOBO.pojo.Page;
import BOBO.pojo.Teacher;

import java.util.List;

public interface CourseService {

    //添加课程
    public void addCourse(Course course);

    //删除课程
    public void deleteCourse(Integer cno);

    //修改课程
    public void updateCourse(Course course);

    //通过名字查询一个课程
    public Course queryCoursebyId(Integer cno);

    //查询多个课程到列表中
    public List<Course> queryCourses();


    Page<Course> page(int pageNo, int pageSize);

    Page<Course> findOneByNo(int pageNo, int pageSize, Integer cno);

    Page<Course> findOneByName(int pageNo, int pageSize, String cname);

}
