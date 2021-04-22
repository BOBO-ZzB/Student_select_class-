package BOBO.filter;

import javax.servlet.*;
import java.io.IOException;

/*
 *
 *用于进行utf-8的编码过滤器
 *
 */

public class EncodeFilter implements Filter {

    String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding != null) {
            //设置request字符编码
            servletRequest.setCharacterEncoding(encoding);
            //设置response字符编码
            servletResponse.setContentType("text/html;charset=" + encoding);
        }
        //传递给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
