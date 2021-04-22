package BOBO.test.DaoTest;

import BOBO.dao.CourseDao;
import BOBO.dao.impl.CourseDaoImpl;
import BOBO.pojo.Course;
import org.junit.Test;


public class CourseDaoTest {

    private CourseDao courseDao = new CourseDaoImpl();

    @Test
    public void addCourse() {
        courseDao.addCourse(new Course(null, "如何成为百万富翁", "11", 2));
    }

    @Test
    public void deleteCourse() {
        courseDao.deleteCourse(206);
    }

    @Test
    public void updateCourse() {
        courseDao.updateCourse(new Course(207, "如何成为百万富翁", "11", 6));
    }

    @Test
    public void queryCoursebyId() {
        System.out.println(courseDao.queryCoursebyId(203));
    }

    @Test
    public void queryCourses() {
        for (Course c : courseDao.queryCourses()) {
            System.out.println(c);
        }
    }
}