package com.ou.servlet;

import com.ou.entity.Admin;
import com.ou.factory.ServiceFactory;
import com.ou.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = (AdminService) ServiceFactory.getService("AdminService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/admin/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.login(username, password);
        if(admin == null){
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("WEB-INF/view/admin/login.jsp").forward(request,response);
        }else {
            request.getSession().setAttribute("admin",admin);
            request.getSession().setAttribute("adminStatus",true);
            out.println("登录成功，3秒后跳转到管理中心！如果没有跳转请点<a href='"+request.getContextPath()+"/admin/manage'>这里</a>");
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/admin/manage");
        }


    }
}
