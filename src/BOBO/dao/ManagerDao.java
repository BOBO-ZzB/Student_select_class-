package BOBO.dao;

import BOBO.pojo.Manager;

import java.util.List;

public interface ManagerDao {
    //通过名字密码找到用户
    public Manager querymanagerbynameandpwd(String name, String password);

    //用于保存管理员
    public int saveManager(Manager manager);

    //通过名字找到用户
    public Manager querymanagerbyname(String name);


    //添加用户
    public int addManager(Manager manager);

    //删除用户
    public int deleteManager(Integer id);

    //修改用户
    public int updateManager(Manager manager);

    //通过ID查询一个用户
    public Manager queryManagerbyId(Integer id);


    //查询
    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Manager> queryForPageItems(int begin, int pageSize);

}
