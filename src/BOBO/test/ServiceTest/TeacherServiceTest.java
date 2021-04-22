package BOBO.test.ServiceTest;

import BOBO.pojo.Teacher;
import BOBO.service.Impl.TeacherServiceImpl;
import BOBO.service.TeacherService;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherServiceTest {

    private TeacherService teacherService = new TeacherServiceImpl();

    @Test
    public void addTeacher() {
        teacherService.addTeacher(new Teacher(null, "周星辉", "男", 50, "学士", "教授", "rapper", "dance", ""));
    }

    @Test
    public void deleteTeacher() {
    }

    @Test
    public void updateTeacher() {
        teacherService.updateTeacher(new Teacher(307, "周星型", "男", 50, "学士", "教授", "rapper", "dance", ""));
    }

    @Test
    public void queryTeacherbyId() {
        System.out.println(teacherService.queryTeacherbyId(307));
    }

    @Test
    public void queryTeachers() {
    }
}