package BOBO.test.DaoTest;

import BOBO.dao.StudentDao;
import BOBO.dao.impl.StudentDaoImpl;
import BOBO.pojo.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    StudentDao studentDao = new StudentDaoImpl();

    @Test
    public void addStudent() {
        studentDao.addStudent(new Student(null, "qwer", "男", 21, "suji机"));
    }

    @Test
    public void deleteStudent() {
        studentDao.deleteStudent(107);
    }

    @Test
    public void updateStudent() {
        studentDao.updateStudent(new Student(114, "范跑跑", "男", 21, "体育系"));
    }

    @Test
    public void queryStudentbyId() {
        System.out.println(studentDao.queryStudentbyId(101));
    }

    @Test
    public void queryStudents() {
        for (Student queryStudent : studentDao.queryStudents()) {
            System.out.println(queryStudent);
        }
    }

    @Test
    public void queryStuByName() {
        List<Student> s = studentDao.queryByName("%鹿%");
        for (Student student : s) {
            System.out.println(student);
        }
    }
}