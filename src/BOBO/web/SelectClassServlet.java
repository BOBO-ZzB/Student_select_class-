package BOBO.web;

import BOBO.pojo.*;
import BOBO.service.CourseService;
import BOBO.service.Impl.CourseServiceImpl;
import BOBO.service.Impl.SctServiceImpl;
import BOBO.service.Impl.StudentServiceImpl;
import BOBO.service.Impl.TeacherServiceImpl;
import BOBO.service.SctService;
import BOBO.service.StudentService;
import BOBO.service.TeacherService;
import BOBO.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectClassServlet extends BaseServlet {

    private SctService sctService = new SctServiceImpl();
    private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    private TeacherService teacherService = new TeacherServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Sct> page = sctService.page(pageNo, pageSize);
        List<Student> list_s = studentService.queryStudents();
        List<Course> list_c = courseService.queryCourses();
        List<Teacher> list_t = teacherService.queryTeachers();

        page.setUrl("selectClassServlet?action=page");

        req.setAttribute("page", page);

        req.getSession().setAttribute("page", page);
        req.getSession().setAttribute("page_s", list_s);
        req.getSession().setAttribute("page_c", list_c);
        req.getSession().setAttribute("page_t", list_t);

        req.getRequestDispatcher("/page/info_pages/SelectClass.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        pageNo += 100;

        Sct sct = WebUtils.WebUtils(req.getParameterMap(), new Sct());

        sctService.addSct(sct);

        resp.sendRedirect(req.getContextPath() + "/selectClassServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        sctService.deleteSct(id);

        resp.sendRedirect(req.getContextPath() + "/selectClassServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sct sct = WebUtils.WebUtils(req.getParameterMap(), new Sct());

        sctService.updateSct(sct);

        resp.sendRedirect(req.getContextPath() + "/selectClassServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getSct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Sct sct = sctService.querySctbyId(id);

        req.setAttribute("sct", sct);

        req.getRequestDispatcher("/page/edit_page/Sct_edit.jsp").forward(req, resp);
    }

    protected void findBySno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sno = WebUtils.parseInt(req.getParameter("sno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Sct> page = sctService.findOneBySno(pageNo, pageSize, sno);

        page.setUrl("selectClassServlet?action=findBySno&sno=" + sno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/SelectClass.jsp").forward(req, resp);
    }

    protected void findByCno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cno = WebUtils.parseInt(req.getParameter("cno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Sct> page = sctService.findOneByCno(pageNo, pageSize, cno);

        page.setUrl("deptServlet?action=findByCno&cno=" + cno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/SelectClass.jsp").forward(req, resp);

    }

}
