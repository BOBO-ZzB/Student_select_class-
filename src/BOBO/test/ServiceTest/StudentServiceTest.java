package BOBO.test.ServiceTest;

import BOBO.pojo.Page;
import BOBO.pojo.Student;
import BOBO.service.Impl.StudentServiceImpl;
import BOBO.service.StudentService;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {
    StudentService studentService = new StudentServiceImpl();

    @Test
    public void addStudent() {
        studentService.addStudent(new Student(null, "wwe", "女", 22, "软件工程"));
    }

    @Test
    public void deleteStudent() {
        studentService.deleteStudent(108);
    }

    @Test
    public void updateStudent() {
        studentService.updateStudent(new Student(114, "李勇志", "男", 20, "软件工程"));
    }

    @Test
    public void queryStudentbyId() {
        System.out.println(studentService.queryStudentbyId(108));
    }

    @Test
    public void queryStudents() {
        for (Student s : studentService.queryStudents()) {
            System.out.println(s);
        }
    }

    @Test
    public void page() {
        System.out.println(studentService.page(1, Page.PAGE_SIZE));
    }
}