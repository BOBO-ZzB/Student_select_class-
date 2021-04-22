package BOBO.dao;

import BOBO.pojo.Course;
import BOBO.pojo.Teacher;

import java.util.List;

public interface CourseDao {

    //添加课程
    public int addCourse(Course course);

    //删除课程
    public int deleteCourse(Integer cno);

    //修改课程
    public int updateCourse(Course course);

    //通过名字查询一个课程
    public Course queryCoursebyId(Integer cno);

    //查询多个课程到列表中
    public List<Course> queryCourses();


    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Course> queryForPageItems(int begin, int pageSize);

    //查询
    //通过名字查找
    List<Course> queryByName(String name);

    //通过ID查找
    List<Course> queryByNo(Integer cno);

    //统计查询的总数量
    Integer queryForTotalCountByNo(Integer cno);

    //统计查询名字的总数量
    Integer queryForTotalCountByName(String cname);

}
