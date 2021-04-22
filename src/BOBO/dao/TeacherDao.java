package BOBO.dao;

import BOBO.pojo.Teacher;

import java.util.List;

public interface TeacherDao {

    //添加老师
    public int addTeacher(Teacher teacher);

    //删除老师
    public int deleteTeacher(Integer tno);

    //修改老师
    public int updateTeacher(Teacher teacher);

    //通过名字查询一个老师
    public Teacher queryTeacherbyId(Integer tno);

    //查询多个老师到列表中
    public List<Teacher> queryTeachers();


    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Teacher> queryForPageItems(int begin, int pageSize);

    //查询
    //通过名字查找学生
    List<Teacher> queryByName(String name);

    //通过学号查找学生
    List<Teacher> queryByNo(Integer tno);

    //统计查询的总数量
    Integer queryForTotalCountByNo(Integer tno);

    //统计查询名字的总数量
    Integer queryForTotalCountByName(String tname);
}
