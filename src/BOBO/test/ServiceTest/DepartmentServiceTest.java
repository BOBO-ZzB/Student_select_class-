package BOBO.test.ServiceTest;

import BOBO.pojo.Department;
import BOBO.service.DepartmentService;
import BOBO.service.Impl.DepartmentServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentServiceTest {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Test
    public void addDepartment() {
        departmentService.addDepartment(new Department(null, "物理学院", "小黄"));
    }

    @Test
    public void deleteDepartment() {
    }

    @Test
    public void updateDepartment() {
        departmentService.updateDepartment(new Department(406, "生物学院", "小gou"));
    }

    @Test
    public void queryDepartmentbyId() {
        System.out.println(departmentService.queryDepartmentbyId(407));
    }

    @Test
    public void queryDepartments() {
    }
}