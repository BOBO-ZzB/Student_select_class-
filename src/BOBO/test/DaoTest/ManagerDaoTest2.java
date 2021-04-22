package BOBO.test.DaoTest;

import BOBO.dao.ManagerDao;
import BOBO.dao.impl.ManagerDaoImpl;
import BOBO.pojo.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerDaoTest2 {

    ManagerDao managerDao = new ManagerDaoImpl();

    @Test
    public void querymanagerbynameandpwd() {
        if (managerDao.querymanagerbynameandpwd("admin", "admina") != null) {
            System.out.println("找到了！");
            //System.out.println(managerDao.querymanagerbynameandpwd());
        } else {
            System.out.println("找不到！");
        }
    }

    @Test
    public void saveManager() {
    }

    @Test
    public void querymanagerbyname() {
    }

    @Test
    public void addManager() {
        managerDao.saveManager(new Manager(null, "jjkk", "jjkk", "0"));
    }

    @Test
    public void deleteManager() {
    }

    @Test
    public void updateManager() {
        managerDao.updateManager(new Manager(5, "jjkk2", "jjkk2", "1"));
    }

    @Test
    public void queryManagerbyId() {
        System.out.println(managerDao.queryManagerbyId(2));
    }

    @Test
    public void queryForTotalCount() {
        System.out.println(managerDao.queryForTotalCount());
    }

    @Test
    public void queryForPageItems() {

    }
}