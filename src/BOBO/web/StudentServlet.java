package BOBO.web;

import BOBO.pojo.Page;
import BOBO.pojo.Sct;
import BOBO.pojo.Student;
import BOBO.service.Impl.SctServiceImpl;
import BOBO.service.Impl.StudentServiceImpl;
import BOBO.service.SctService;
import BOBO.service.StudentService;
import BOBO.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends BaseServlet {
    //调用对应的service层函数
    private StudentService studentService = new StudentServiceImpl();
    private SctService sctService = new SctServiceImpl();

    //添加学生信息
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获取当前页码*/
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        /*保证添加信息后跳到最后一页，+100*/
        pageNo += 100;
        /*把获取到的对象注入映射Map中*/
        Student student = WebUtils.WebUtils(req.getParameterMap(), new Student());
        /*调用service方法添加*/
        studentService.addStudent(student);
        /*重定向地址到信息展示，加上属性pageNo*/
        resp.sendRedirect(req.getContextPath() + "/studentServlet?action=page&pageNo=" + pageNo);
    }

    //删除学生信息
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获取点击删除的ID*/
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        /*新建一个Sct选课对象，并通过学号ID查找是否存在*/
        Sct sct = sctService.querySctbySno(id);
        /*不存在，则直接删*/
        if (sct == null) {
            studentService.deleteStudent(id);
        }
        /*存在，先删选课信息，再删学生信息，防止产生依赖，报错*/
        else {
            sctService.deleteSct(sct.getSct_no());
            studentService.deleteStudent(id);
        }
        /*重定向地址到信息展示，加上属性pageNo*/
        resp.sendRedirect(req.getContextPath() + "/studentServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    //修改学生信息
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*把获取到的对象注入映射Map中*/
        Student student = WebUtils.WebUtils(req.getParameterMap(), new Student());

        studentService.updateStudent(student);

        resp.sendRedirect(req.getContextPath() + "/studentServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }

    //获取学生信息，获取后跳到学生编辑界面
    protected void getStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Student student = studentService.queryStudentbyId(id);
        /*把student存到resquest域中*/
        req.setAttribute("studnet", student);
        /*进行编辑页面跳转*/
        req.getRequestDispatcher("/page/edit_page/Student_edit.jsp").forward(req, resp);

    }

    //处理分页服务
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        /*新建一个page对象*/
        Page<Student> page = studentService.page(pageNo, pageSize);
        /*设置Url，用于分页处理*/
        page.setUrl("studentServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Student.jsp").forward(req, resp);

    }

    //通过学号查找学生信息
    protected void findByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int sno = WebUtils.parseInt(req.getParameter("sno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Student> page = studentService.findOneByNo(pageNo, pageSize, sno);

        page.setUrl("studentServlet?action=findByNo&sno=" + sno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Student.jsp").forward(req, resp);

    }

    protected void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sno = WebUtils.parseInt(req.getParameter("sno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        String sname = new String(req.getParameter("sname").getBytes("ISO-8859-1"),"utf-8");
        String sname = req.getParameter("sname");
        Page<Student> page = studentService.findOneByName(pageNo, pageSize, sname);

        page.setUrl("studentServlet?action=findByName&sname=" + sname);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Student.jsp").forward(req, resp);
    }

    //列出所有学生信息（没用）
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = studentService.queryStudents();

        req.setAttribute("students", students);

        req.getRequestDispatcher("/page/info_pages/Student.jsp").forward(req, resp);
    }

}
