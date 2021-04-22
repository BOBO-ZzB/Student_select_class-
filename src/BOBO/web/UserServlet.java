package BOBO.web;

import BOBO.pojo.Manager;
import BOBO.pojo.Page;
import BOBO.service.Impl.ManagerServiceImpl;
import BOBO.service.ManagerService;
import BOBO.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private ManagerService managerService = new ManagerServiceImpl();

    //用于登录
    protected void Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        Manager loginmanager = managerService.login(new Manager(null, username, password, type));

        if (loginmanager == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);

            req.getRequestDispatcher("/page/user/Login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("manager", loginmanager);
            req.getRequestDispatcher("/page/user/Login_success.jsp").forward(req, resp);
        }

    }

    //用于注册
    protected void Regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取图片中的验证码内容
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //获取后立马删除验证码内容，以免页面刷新更改
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //获取输入的用户名、密码、验证码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        String code = req.getParameter("code");
        //吧各个属性输入到bean对象中
        Manager manager = WebUtils.WebUtils(req.getParameterMap(), new Manager());


        //首先检测验证码
        if (token != null && token.equalsIgnoreCase(code)) {
            //验证用户名是否存在
            if (managerService.existsUsername(username)) {
                req.setAttribute("msg", "该用户已存在！");
                req.setAttribute("username", username);
                req.getRequestDispatcher("/page/user/Regist.jsp").forward(req, resp);
            } else {
                //用户名可用，保存到数据库，并自动登录，返回主页面
                managerService.register(new Manager(null, username, password, type));
                req.getSession().setAttribute("manager", manager);
                req.getRequestDispatcher("/page/user/Login_success.jsp").forward(req, resp);
            }

        } else {
            //验证码错误时
            req.setAttribute("msg", "验证码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/page/user/Regist.jsp").forward(req, resp);

        }
    }

    //注销用户
    protected void Logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁session中的内容
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);

        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Manager> page = managerService.page(pageNo, pageSize);

        page.setUrl("userServlet?action=page");

        req.setAttribute("page", page);

        req.getRequestDispatcher("/page/info_pages/User.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        pageNo += 100;

        Manager manager = WebUtils.WebUtils(req.getParameterMap(), new Manager());

        managerService.addManager(manager);

        resp.sendRedirect(req.getContextPath() + "/userServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        managerService.deleteManager(id);

        resp.sendRedirect(req.getContextPath() + "/userServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Manager manager = WebUtils.WebUtils(req.getParameterMap(), new Manager());

        managerService.updateManager(manager);

        resp.sendRedirect(req.getContextPath() + "/userServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void getManager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        Manager manager = managerService.queryManagerbyId(id);

        req.setAttribute("manager", manager);

        req.getRequestDispatcher("/page/edit_page/User_edit.jsp").forward(req, resp);
    }

}
