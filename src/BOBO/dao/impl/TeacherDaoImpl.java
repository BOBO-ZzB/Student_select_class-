package BOBO.dao.impl;

import BOBO.dao.TeacherDao;
import BOBO.pojo.Teacher;

import java.util.List;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    @Override
    public int addTeacher(Teacher teacher) {
        String sql = "insert into teacher value(?,?,?,?,?,?,?,?,?)";
        return update(sql, teacher.getTno(), teacher.getTname(), teacher.getTsex(), teacher.getTage(), teacher.getTeb(), teacher.getTpt(),
                teacher.getCno1(), teacher.getCno2(), teacher.getCno3());

    }

    @Override
    public int deleteTeacher(Integer tno) {
        String sql = "delete from teacher where tno=?";
        return update(sql, tno);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        String sql = "update teacher set tname=?,tsex=?,tage=?,teb=?,tpt=?,cno1=?,cno2=?,cno3=? where tno=? ";
        return update(sql, teacher.getTname(), teacher.getTsex(), teacher.getTage(), teacher.getTeb(), teacher.getTpt(),
                teacher.getCno1(), teacher.getCno2(), teacher.getCno3(), teacher.getTno());
    }

    @Override
    public Teacher queryTeacherbyId(Integer tno) {
        String sql = "select * from teacher where tno=?";
        return queryForone(Teacher.class, sql, tno);
    }

    @Override
    public List<Teacher> queryTeachers() {
        String sql = "select * from teacher ";
        return queryForlist(Teacher.class, sql);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(1) from teacher";
        Number count = (Number) queryForsingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Teacher> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from teacher limit ?,?";
        return queryForlist(Teacher.class, sql, begin, pageSize);
    }

    @Override
    public List<Teacher> queryByName(String name) {
        String sql = "select * from teacher where tname like ?";
        return queryForlist(Teacher.class, sql, name);
    }

    @Override
    public List<Teacher> queryByNo(Integer tno) {
        String sql = "select * from teacher where tno=?";
        return queryForlist(Teacher.class, sql, tno);
    }

    @Override
    public Integer queryForTotalCountByNo(Integer tno) {
        String sql = "select count(*) from teacher where tno=?";
        Number count = (Number) queryForsingleValue(sql, tno);
        return count.intValue();
    }

    @Override
    public Integer queryForTotalCountByName(String tname) {
        String sql = "select count(*) from teacher where tname like ?";
        Number count = (Number) queryForsingleValue(sql, tname);
        return count.intValue();
    }
}
