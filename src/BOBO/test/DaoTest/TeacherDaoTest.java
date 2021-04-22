package BOBO.test.DaoTest;

import BOBO.dao.TeacherDao;
import BOBO.dao.impl.TeacherDaoImpl;
import BOBO.pojo.Teacher;
import org.junit.Test;

public class TeacherDaoTest {

    private TeacherDao teacherDao = new TeacherDaoImpl();

    @Test
    public void addTeacher() {
        teacherDao.addTeacher(new Teacher(null, "飞鱼星", "男", 50, "学士", "教授", "rapper", null, null));
    }

    @Test
    public void deleteTeacher() {
        teacherDao.deleteTeacher(306);
    }

    @Test
    public void updateTeacher() {
        teacherDao.updateTeacher(new Teacher(305, "费玉清", "男", 50, "学士", "教授", "rapper", "dance", null));
    }

    @Test
    public void queryTeacherbyId() {
        System.out.println(teacherDao.queryTeacherbyId(302));
    }

    @Test
    public void queryTeachers() {
        for (Teacher t : teacherDao.queryTeachers()) {
            System.out.println(t);
        }
    }
}