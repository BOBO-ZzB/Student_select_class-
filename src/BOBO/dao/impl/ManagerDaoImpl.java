package BOBO.dao.impl;

import BOBO.dao.ManagerDao;
import BOBO.pojo.Manager;

import java.util.List;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {

    @Override
    public Manager querymanagerbynameandpwd(String name, String password) {
        String sql = "select * from manager where username = ? and password = ?";
        return queryForone(Manager.class, sql, name, password);
    }

    @Override
    public int saveManager(Manager manager) {
        String sql = "insert into manager(username,password,type) values(?,?,?)";
        return update(sql, manager.getUsername(), manager.getPassword(), manager.getType());
    }

    @Override
    public Manager querymanagerbyname(String name) {
        String sql = "select * from manager where username = ? ";
        return queryForone(Manager.class, sql, name);
    }


    @Override
    public int addManager(Manager manager) {
        String sql = "insert into manager value(?,?,?,?)";
        return update(sql, manager.getId(), manager.getUsername(), manager.getPassword(), manager.getType());
    }

    @Override
    public int deleteManager(Integer id) {
        String sql = "delete from manager where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateManager(Manager manager) {
        String sql = "update manager set username=?,password=?,type=? where id=?";
        return update(sql, manager.getUsername(), manager.getPassword(), manager.getType(), manager.getId());
    }

    @Override
    public Manager queryManagerbyId(Integer id) {
        String sql = "select * from manager where id=?";
        return queryForone(Manager.class, sql, id);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(1) from manager";
        Number count = (Number) queryForsingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Manager> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from manager limit ?,?";
        return queryForlist(Manager.class, sql, begin, pageSize);
    }

}
