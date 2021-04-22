package BOBO.service.Impl;

import BOBO.dao.SctDao;
import BOBO.dao.impl.SctDaoImpl;
import BOBO.pojo.Page;
import BOBO.pojo.Sct;
import BOBO.service.SctService;

import java.util.List;

public class SctServiceImpl implements SctService {

    private SctDao sctDao = new SctDaoImpl();

    @Override
    public void addSct(Sct sct) {
        sctDao.addSct(sct);
    }

    @Override
    public void deleteSct(Integer sct_no) {
        sctDao.deleteSct(sct_no);
    }

    @Override
    public void updateSct(Sct sct) {
        sctDao.updateSct(sct);
    }

    @Override
    public Sct querySctbyId(Integer sct_no) {
        return sctDao.querySctbyId(sct_no);
    }

    @Override
    public Sct querySctbySno(Integer sno) {
        return sctDao.querySctbySno(sno);
    }

    @Override
    public Sct querySctbyCno(Integer cno) {
        return sctDao.querySctbyCno(cno);
    }

    @Override
    public Sct querySctbyTno(Integer tno) {
        return sctDao.querySctbyTno(tno);
    }

    @Override
    public Page<Sct> page(int pageNo, int pageSize) {
        Page<Sct> page = new Page<Sct>();

        page.setPageSize(pageSize);

        Integer totalCount = sctDao.queryForTotalCount();

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;

        List<Sct> items = sctDao.queryForPageItems(begin, pageSize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Sct> findOneBySno(int pageNo, int pageSize, Integer sno) {
        Page<Sct> page = new Page<Sct>();

        page.setPageSize(pageSize);

        Integer totalCount = sctDao.queryForTotalCountBySno(sno);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Sct> items = sctDao.queryBySno(sno);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Sct> findOneByCno(int pageNo, int pageSize, Integer cno) {
        Page<Sct> page = new Page<Sct>();

        page.setPageSize(pageSize);

        Integer totalCount = sctDao.queryForTotalCountByCno(cno);

        page.setPageTotalCount(totalCount);

        Integer pageTotal = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Sct> items = sctDao.queryByCno(cno);

        page.setItems(items);

        return page;
    }

    @Override
    public List<Sct> queryScts() {
        return sctDao.queryScts();
    }
}
