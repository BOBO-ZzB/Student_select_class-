package BOBO.filter;

/*
 * 用作权限过滤，不允许直接输入地址进入系统，必须进行登录验证。
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        Object user = httpServletRequest.getSession().getAttribute("manager");

        //进行判断，是否需要拦截
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/page/user/Login.jsp").forward(servletRequest, servletResponse);
        } else {
            //如果通过就放行
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
