package BOBO.service;

import BOBO.pojo.Page;
import BOBO.pojo.Student;

import java.util.List;

public interface StudentService {

    //添加学生
    public void addStudent(Student student);

    //删除学生
    public void deleteStudent(Integer sno);

    //修改学生
    public void updateStudent(Student student);

    //通过学号查询一个学生
    public Student queryStudentbyId(Integer sno);

    //查询多个学生到列表中
    public List<Student> queryStudents();

    //进行分页
    Page<Student> page(int pageNo, int pageSize);

    //通过学号查找后进行分页
    Page<Student> findOneByNo(int pageNo, int pageSize, Integer sno);

    //通过名字查找后进行分页
    Page<Student> findOneByName(int pageNo, int pageSize, String sname);
}
