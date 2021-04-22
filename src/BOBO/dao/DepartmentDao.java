package BOBO.dao;

import BOBO.pojo.Course;
import BOBO.pojo.Department;

import java.util.List;

public interface DepartmentDao {
    //添加院系
    public int addDepartment(Department department);

    //删除院系
    public int deleteDepartment(Integer dno);

    //修改院系
    public int updateDepartment(Department department);

    //通过名字查询一个院系
    public Department queryDepartmentbyId(Integer dno);

    //查询多个院系到列表中
    public List<Department> queryDepartments();


    //统计全部列数量
    Integer queryForTotalCount();

    //查找一页的数量
    List<Department> queryForPageItems(int begin, int pageSize);

    //查询
    //通过名字查找
    List<Department> queryByName(String name);

    //通过ID查找
    List<Department> queryByNo(Integer dno);

    //统计查询的总数量
    Integer queryForTotalCountByNo(Integer dno);

    //统计查询名字的总数量
    Integer queryForTotalCountByName(String dname);

}
