package com.ou.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/manage/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if(request.getSession().getAttribute("admin") == null||!(boolean) request.getSession().getAttribute("adminStatus")) {
            System.out.println(request.getSession().getAttribute("admin") == null);
            System.out.println((boolean) request.getSession().getAttribute("adminStatus"));
            request.setAttribute("msg", "无权限访问,请登录管理员用户");
            request.getRequestDispatcher("/admin").forward(request, response);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
