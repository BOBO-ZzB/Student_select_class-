package BOBO.web;

import BOBO.pojo.Course;
import BOBO.pojo.Page;
import BOBO.pojo.Sct;
import BOBO.pojo.Teacher;
import BOBO.service.CourseService;
import BOBO.service.Impl.CourseServiceImpl;
import BOBO.service.Impl.SctServiceImpl;
import BOBO.service.Impl.TeacherServiceImpl;
import BOBO.service.SctService;
import BOBO.service.TeacherService;
import BOBO.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherServlet extends BaseServlet {

    private TeacherService teacherService = new TeacherServiceImpl();
    private SctService sctService = new SctServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Teacher> page = teacherService.page(pageNo, pageSize);
        List<Course> list_c = courseService.queryCourses();

        page.setUrl("teacherServlet?action=page");

        req.setAttribute("page", page);
        req.getSession().setAttribute("page_c", list_c);

        req.getRequestDispatcher("/page/info_pages/Teacher.jsp").forward(req, resp);

    }

    //进行添加功能实现方法
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        pageNo += 100;

        Teacher teacher = WebUtils.WebUtils(req.getParameterMap(), new Teacher());

        teacherService.addTeacher(teacher);

        resp.sendRedirect(req.getContextPath() + "/teacherServlet?action=page&pageNo=" + pageNo);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = WebUtils.WebUtils(req.getParameterMap(), new Teacher());

        teacherService.updateTeacher(teacher);

        resp.sendRedirect(req.getContextPath() + "/teacherServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Sct sct = sctService.querySctbyTno(id);
        if (sct == null) {
            teacherService.deleteTeacher(id);
        } else {
            sctService.deleteSct(sct.getSct_no());
            teacherService.deleteTeacher(id);
        }

        resp.sendRedirect(req.getContextPath() + "/teacherServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Teacher teacher = teacherService.queryTeacherbyId(id);

        req.setAttribute("teacher", teacher);

        req.getRequestDispatcher("/page/edit_page/Teacher_edit.jsp").forward(req, resp);
    }

    protected void findByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int tno = WebUtils.parseInt(req.getParameter("tno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Teacher> page = teacherService.findOneByNo(pageNo, pageSize, tno);

        page.setUrl("teacherServlet?action=findByNo&tno=" + tno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Teacher.jsp").forward(req, resp);

    }

    protected void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tno = WebUtils.parseInt(req.getParameter("tno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        String tname = new String(req.getParameter("tname").getBytes("ISO-8859-1"),"utf-8");
        String tname = req.getParameter("tname");
        Page<Teacher> page = teacherService.findOneByName(pageNo, pageSize, tname);

        page.setUrl("teacherServlet?action=findByName&tname=" + tname);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Teacher.jsp").forward(req, resp);
    }

}
