package BOBO.dao;

import BOBO.pojo.Sct;
import BOBO.pojo.Student;

import java.util.List;

public interface SctDao {

    //添加选课信息
    public int addSct(Sct sct);

    //删除选课信息
    public int deleteSct(Integer sct_no);

    //修改选课信息
    public int updateSct(Sct sct);

    //通过编号ID查询一个选课信息
    public Sct querySctbyId(Integer sct_no);

    public Sct querySctbySno(Integer sno);

    public Sct querySctbyCno(Integer cno);

    public Sct querySctbyTno(Integer tno);


    public List<Sct> queryScts();

    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Sct> queryForPageItems(int begin, int pageSize);

    //查询
    //通过sno查找
    List<Sct> queryBySno(Integer sno);

    //通过cno查找
    List<Sct> queryByCno(Integer cno);

    //统计查询sno的总数量
    Integer queryForTotalCountBySno(Integer sno);

    //统计查询cno的总数量
    Integer queryForTotalCountByCno(Integer cno);


}
