package BOBO.dao.impl;

import BOBO.dao.DepartmentDao;
import BOBO.pojo.Department;

import java.util.List;

public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {
    @Override
    public int addDepartment(Department department) {
        String sql = "insert into department value(?,?,?)";
        return update(sql, department.getDno(), department.getDname(), department.getDmanagerno());
    }

    @Override
    public int deleteDepartment(Integer dno) {
        String sql = "delete from department where dno=?";
        return update(sql, dno);
    }

    @Override
    public int updateDepartment(Department department) {
        String sql = "update department set dname=?,dmanagerno=? where dno=?";
        return update(sql, department.getDname(), department.getDmanagerno(), department.getDno());
    }

    @Override
    public Department queryDepartmentbyId(Integer dno) {
        String sql = "select * from department where dno=?";
        return queryForone(Department.class, sql, dno);
    }

    @Override
    public List<Department> queryDepartments() {
        String sql = "select * from department";
        return queryForlist(Department.class, sql);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(1) from department";
        Number count = (Number) queryForsingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Department> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from department limit ?,?";
        return queryForlist(Department.class, sql, begin, pageSize);
    }

    @Override
    public List<Department> queryByName(String name) {
        String sql = "select * from department where dname like ?";
        return queryForlist(Department.class, sql, name);
    }

    @Override
    public List<Department> queryByNo(Integer dno) {
        String sql = "select * from department where dno = ?";
        return queryForlist(Department.class, sql, dno);
    }

    @Override
    public Integer queryForTotalCountByNo(Integer dno) {
        String sql = "select count(1) from department where dno = ?";
        Number count = (Number) queryForsingleValue(sql, dno);
        return count.intValue();
    }

    @Override
    public Integer queryForTotalCountByName(String dname) {
        String sql = "select count(1) from department where dname like ?";
        Number count = (Number) queryForsingleValue(sql, dname);
        return count.intValue();
    }
}
