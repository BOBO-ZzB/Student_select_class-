package BOBO.dao.impl;

import BOBO.dao.StudentDao;
import BOBO.pojo.Student;

import java.util.List;


//继承了StudentDao接口，并实现对应方法（写SQL语句）
public class StudentDaoImpl extends BaseDao implements StudentDao {
    @Override
    public int addStudent(Student student) {
        String sql = "insert into student value(?,?,?,?,?)";
        return update(sql, student.getSno(), student.getSname(), student.getSsex(), student.getSage(), student.getSdept());
    }

    @Override
    public int deleteStudent(Integer sno) {
        String sql = "delete from student where sno=?";
        return update(sql, sno);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set sname=?,ssex=?,sage=?,sdept=? where sno=?";
        return update(sql, student.getSname(), student.getSsex(), student.getSage(), student.getSdept(), student.getSno());
    }

    @Override
    public Student queryStudentbyId(Integer sno) {
        String sql = "select * from student where sno=?";
        return queryForone(Student.class, sql, sno);
    }

    @Override
    public List<Student> queryStudents() {
        String sql = "select * from student";
        return queryForlist(Student.class, sql);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(*) from student";
        //返回一个数值（总的学生数量）
        Number count = (Number) queryForsingleValue(sql);

        return count.intValue();
    }

    @Override
    public List<Student> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from student limit ?,?";
        return queryForlist(Student.class, sql, begin, pageSize);
    }

    @Override
    public List<Student> queryByName(String name) {
        String sql = "select * from student where sname like ?";
        return queryForlist(Student.class, sql, name);
    }

    @Override
    public List<Student> queryByNo(Integer sno) {
        String sql = "select * from student where sno=?";
        return queryForlist(Student.class, sql, sno);
    }

    @Override
    public Integer queryForTotalCountByNo(Integer sno) {
        String sql = "select count(*) from student where sno=?";
        Number count = (Number) queryForsingleValue(sql, sno);
        return count.intValue();
    }

    @Override
    public Integer queryForTotalCountByName(String sname) {
        String sql = "select count(*) from student where sname like ?";
        Number count = (Number) queryForsingleValue(sql, sname);
        return count.intValue();
    }

}
