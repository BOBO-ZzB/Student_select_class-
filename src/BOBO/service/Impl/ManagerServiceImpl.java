package BOBO.service.Impl;

import BOBO.dao.ManagerDao;
import BOBO.dao.impl.ManagerDaoImpl;
import BOBO.pojo.Manager;
import BOBO.pojo.Page;
import BOBO.pojo.Teacher;
import BOBO.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao = new ManagerDaoImpl();


    @Override
    public Manager login(Manager manager) {
        return managerDao.querymanagerbynameandpwd(manager.getUsername(), manager.getPassword());
    }

    @Override
    public void register(Manager manager) {
        managerDao.saveManager(manager);
    }

    @Override
    public boolean existsUsername(String username) {
        if (managerDao.querymanagerbyname(username) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addManager(Manager manager) {
        managerDao.addManager(manager);
    }

    @Override
    public void deleteManager(Integer id) {
        managerDao.deleteManager(id);
    }

    @Override
    public void updateManager(Manager manager) {
        managerDao.updateManager(manager);
    }

    @Override
    public Manager queryManagerbyId(Integer id) {
        return managerDao.queryManagerbyId(id);
    }

    @Override
    public Page<Manager> page(int pageNo, int pageSize) {
        Page<Manager> page = new Page<Manager>();

        //设置每页的条数
        page.setPageSize(pageSize);
        //记录总记录数
        Integer totalCount = managerDao.queryForTotalCount();
        //设置总记录数
        page.setPageTotalCount(totalCount);
        //求总页码数
        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);

        //获取当前页码数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Manager> items = managerDao.queryForPageItems(begin, pageSize);
        //放到ietms属性中，后面方便调用
        page.setItems(items);

        return page;
    }
}
