package BOBO.test.ServiceTest;

import BOBO.dao.ManagerDao;
import BOBO.dao.impl.ManagerDaoImpl;
import BOBO.pojo.Manager;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerServiceTest {

    ManagerDao managerDao = new ManagerDaoImpl();

    @Test
    public void querymanagerbyname() {
        System.out.println(managerDao.querymanagerbynameandpwd("bobo", "123456"));
    }

    @Test
    public void saveManager() {
        managerDao.saveManager(new Manager(null, "coco", "123456", "0"));
    }
}