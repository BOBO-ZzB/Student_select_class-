package BOBO.test.DaoTest;

import BOBO.dao.SctDao;
import BOBO.dao.impl.SctDaoImpl;
import BOBO.pojo.Sct;
import org.junit.Test;

public class SctDaoTest {

    private SctDao sctDao = new SctDaoImpl();

    @Test
    public void addSct() {
        sctDao.addSct(new Sct(null, 103, 201, 302, 60));
    }

    @Test
    public void deleteSct() {
        sctDao.deleteSct(504);
    }

    @Test
    public void updateSct() {
        sctDao.updateSct(new Sct(500, 100, 200, 303, 75));
    }

    @Test
    public void querySctbyId() {
        Sct sct = sctDao.querySctbyId(500);
        System.out.println(sct);
    }

    @Test
    public void queryForTotalCount() {
        int i = sctDao.queryForTotalCount();
        System.out.println(i);
    }

    @Test
    public void queryForPageItems() {
    }

    @Test
    public void queryBySno() {
    }

    @Test
    public void queryByCno() {
    }

    @Test
    public void queryForTotalCountBySno() {
    }

    @Test
    public void queryForTotalCountByCno() {
    }
}