package com.ou.servlet;

import com.ou.entity.User;
import com.ou.factory.ServiceFactory;
import com.ou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = (UserService) ServiceFactory.getService("UserService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String telNumber = request.getParameter("telNumber");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            user.setBirthday(dateFormat.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(email);
        user.setTelNumber(telNumber);

        int register = userService.register(user);
        if (register>0){
            out.println("用户注册成功，三秒后跳转页面，未跳转点击<a href='"+request.getContextPath()+"/login'>这里</a>");
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/login");
        }else{
            request.setAttribute("msg","用户名已存在");
            request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request,response);
        }
    }
}
