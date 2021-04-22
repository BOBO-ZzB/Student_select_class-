package BOBO.dao.impl;

import BOBO.dao.SctDao;
import BOBO.pojo.Sct;

import java.util.List;

public class SctDaoImpl extends BaseDao implements SctDao {

    @Override
    public int addSct(Sct sct) {
        String sql = "insert into sct values (?,?,?,?,?)";
        return update(sql, sct.getSct_no(), sct.getSno(), sct.getCno(), sct.getTno(), sct.getGrade());
    }

    @Override
    public int deleteSct(Integer sct_no) {
        String sql = "delete from sct where sct_no = ?";
        return update(sql, sct_no);
    }

    @Override
    public int updateSct(Sct sct) {
        String sql = "update sct set sno=?,cno=?,tno=?,grade=? where sct_no=?";
        return update(sql, sct.getSno(), sct.getCno(), sct.getTno(), sct.getGrade(), sct.getSct_no());
    }

    @Override
    public Sct querySctbyId(Integer sct_no) {
        String sql = "select * from sct where sct_no=?";
        return queryForone(Sct.class, sql, sct_no);
    }

    @Override
    public Sct querySctbySno(Integer sno) {
        String sql = "select * from sct where sno=?";
        return queryForone(Sct.class, sql, sno);
    }

    @Override
    public Sct querySctbyCno(Integer cno) {
        String sql = "select * from sct where cno=?";
        return queryForone(Sct.class, sql, cno);
    }

    @Override
    public Sct querySctbyTno(Integer tno) {
        String sql = "select * from sct where tno=?";
        return queryForone(Sct.class, sql, tno);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(1) from sct";
        Number count = (Number) queryForsingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Sct> queryForPageItems(int begin, int pageSize) {
        if (begin < 0) begin = 0;
        String sql = "select * from sct limit ?,?";
        return queryForlist(Sct.class, sql, begin, pageSize);
    }

    @Override
    public List<Sct> queryBySno(Integer sno) {
        String sql = "select * from sct where sno=?";
        return queryForlist(Sct.class, sql, sno);
    }

    @Override
    public List<Sct> queryByCno(Integer cno) {
        String sql = "select * from sct where cno=?";
        return queryForlist(Sct.class, sql, cno);
    }

    @Override
    public Integer queryForTotalCountBySno(Integer sno) {
        String sql = "select count(1) from sct where sno = ?";
        Number count = (Number) queryForsingleValue(sql, sno);
        return count.intValue();
    }

    @Override
    public Integer queryForTotalCountByCno(Integer cno) {
        String sql = "select count(1) from sct where cno = ? ";
        Number count = (Number) queryForsingleValue(sql, cno);
        return count.intValue();
    }

    @Override
    public List<Sct> queryScts() {
        String sql = "select * from sct";
        return queryForlist(Sct.class, sql);
    }
}
