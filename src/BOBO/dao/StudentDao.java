package BOBO.dao;

import BOBO.pojo.Student;

import java.util.List;

public interface StudentDao {

    //添加学生
    public int addStudent(Student student);

    //删除学生
    public int deleteStudent(Integer sno);

    //修改学生
    public int updateStudent(Student student);

    //通过学号查询一个学生
    public Student queryStudentbyId(Integer sno);

    //查询多个学生到列表中
    public List<Student> queryStudents();

    //查询
    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Student> queryForPageItems(int begin, int pageSize);

    //通过名字查找学生
    List<Student> queryByName(String name);

    //通过学号查找学生
    List<Student> queryByNo(Integer sno);

    //统计查询学号的总数量
    Integer queryForTotalCountByNo(Integer sno);

    //统计查询名字的总数量
    Integer queryForTotalCountByName(String sname);
}
