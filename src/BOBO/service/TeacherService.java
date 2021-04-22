package BOBO.service;

import BOBO.pojo.Page;
import BOBO.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    //添加老师
    public void addTeacher(Teacher teacher);

    //删除老师
    public void deleteTeacher(Integer tno);

    //修改老师
    public void updateTeacher(Teacher teacher);

    //通过名字查询一个老师
    public Teacher queryTeacherbyId(Integer tno);

    //查询多个老师到列表中
    public List<Teacher> queryTeachers();

    //进行老师分页
    Page<Teacher> page(int pageNo, int pageSize);

    Page<Teacher> findOneByNo(int pageNo, int pageSize, Integer tno);

    Page<Teacher> findOneByName(int pageNo, int pageSize, String tname);

}
