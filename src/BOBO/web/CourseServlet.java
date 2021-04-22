package BOBO.web;

import BOBO.pojo.Course;
import BOBO.pojo.Page;
import BOBO.pojo.Sct;
import BOBO.service.CourseService;
import BOBO.service.Impl.CourseServiceImpl;
import BOBO.service.Impl.SctServiceImpl;
import BOBO.service.SctService;
import BOBO.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseServlet extends BaseServlet {

    private CourseService courseService = new CourseServiceImpl();
    private SctService sctService = new SctServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Course> page = courseService.page(pageNo, pageSize);

        page.setUrl("courseServlet?action=page");

        req.setAttribute("page", page);
//        req.getSession().setAttribute("page_c",page);

        req.getRequestDispatcher("/page/info_pages/Course.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        pageNo += 100;

        Course course = WebUtils.WebUtils(req.getParameterMap(), new Course());

        courseService.addCourse(course);

        resp.sendRedirect(req.getContextPath() + "/courseServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Sct sct = sctService.querySctbyCno(id);

        if (sct == null) {
            courseService.deleteCourse(id);
        } else {
            sctService.deleteSct(sct.getSct_no());
            courseService.deleteCourse(id);
        }
        resp.sendRedirect(req.getContextPath() + "/courseServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = WebUtils.WebUtils(req.getParameterMap(), new Course());

        courseService.updateCourse(course);

        resp.sendRedirect(req.getContextPath() + "/courseServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Course course = courseService.queryCoursebyId(id);

        req.setAttribute("course", course);

        req.getRequestDispatcher("/page/edit_page/Course_edit.jsp").forward(req, resp);
    }

    protected void findByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cno = WebUtils.parseInt(req.getParameter("cno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Course> page = courseService.findOneByNo(pageNo, pageSize, cno);

        page.setUrl("courseServlet?action=findByNo&cno=" + cno);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Course.jsp").forward(req, resp);
    }

    protected void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cno = WebUtils.parseInt(req.getParameter("cno"), 1);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
//        String cname = new String(req.getParameter("cname").getBytes("ISO-8859-1"),"utf-8");
        String cname = req.getParameter("cname");

        Page<Course> page = courseService.findOneByName(pageNo, pageSize, cname);

        page.setUrl("courseServlet?action=findByName&cname=" + cname);

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/Course.jsp").forward(req, resp);

    }


}
