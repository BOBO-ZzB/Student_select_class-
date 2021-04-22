package BOBO.test.ServiceTest;

import BOBO.pojo.Course;
import BOBO.service.CourseService;
import BOBO.service.Impl.CourseServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseServiceTest {

    private CourseService courseService = new CourseServiceImpl();

    @Test
    public void addCourse() {
        courseService.addCourse(new Course(null, "如何成为亿万富翁", "13", 4));
    }

    @Test
    public void deleteCourse() {
    }

    @Test
    public void updateCourse() {
        courseService.updateCourse(new Course(208, "如何成为十万富翁", "13", 2));
    }

    @Test
    public void queryCoursebyId() {
        System.out.println(courseService.queryCoursebyId(208));
    }

    @Test
    public void queryCourses() {
        for (Course course : courseService.queryCourses()) {
            System.out.println(course);
        }
    }
}