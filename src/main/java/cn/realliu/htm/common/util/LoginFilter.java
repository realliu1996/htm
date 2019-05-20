package cn.realliu.htm.common.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: 刘真
 * @Date: 2019/4/19
 * @Time: 23:49
 * @Description：过滤器
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();

        String servletPath = request.getServletPath();

        if (session.getAttribute("user") == null){

            if (servletPath.equals("/house/selectOrder") || servletPath.equals("/showIndex") || servletPath.equals("/showlogin") ||
                servletPath.equals("/showregister") || servletPath.contains("image/") || servletPath.contains("dist/") ||
                servletPath.contains("bower_components/") || servletPath.contains("plugins/") || servletPath.equals("/user/userLogin") ||
                servletPath.contains("/user/userNameCheck") || servletPath.contains("/user/userRegister") || servletPath.equals("/house/selectAll") ||
                servletPath.contains("/showHousing")
            ){
                arg2.doFilter(arg0, arg1);
            }else {
                //response.sendRedirect(request.getContextPath()+"/showlogin");
                session.setAttribute("msg","请登录");
                request.getRequestDispatcher("/showlogin").forward(request,response);
            }
        }else {

            arg2.doFilter(arg0, arg1);
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
