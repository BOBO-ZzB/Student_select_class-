package BOBO.service;

import BOBO.pojo.Manager;
import BOBO.pojo.Page;

public interface ManagerService {

    //登录业务
    public Manager login(Manager manager);

    //注册业务
    public void register(Manager manager);

    //查询用户名是否可用
    public boolean existsUsername(String username);


    //添加用户
    public void addManager(Manager manager);

    //删除用户
    public void deleteManager(Integer id);

    //修改用户
    public void updateManager(Manager manager);

    //通过名字查询一个用户
    public Manager queryManagerbyId(Integer id);

    //进行用户分页
    Page<Manager> page(int pageNo, int pageSize);


}
