package BOBO.service;

import BOBO.pojo.Department;
import BOBO.pojo.Page;

import java.util.List;

public interface DepartmentService {

    //添加院系
    public void addDepartment(Department department);

    //删除院系
    public void deleteDepartment(Integer dno);

    //修改院系
    public void updateDepartment(Department department);

    //通过名字查询一个院系
    public Department queryDepartmentbyId(Integer dno);

    //查询多个院系到列表中
    public List<Department> queryDepartments();


    Page<Department> page(int pageNo, int pageSize);

    Page<Department> findOneByNo(int pageNo, int pageSize, Integer dno);

    Page<Department> findOneByName(int pageNo, int pageSize, String dname);

}
