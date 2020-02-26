package com.ou.servlet;

import com.ou.entity.User;
import com.ou.factory.ServiceFactory;
import com.ou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = (UserService) ServiceFactory.getService("UserService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //out必须写在设置字符集之后，写在之前out已初始化，使用默认编码
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if(user != null){
            if(request.getParameter("remember") != null){
                Cookie usernameCookie = new Cookie("rememberUsername",username);
                usernameCookie.setMaxAge(7*24*60*60);
                Cookie passwordCookie = new Cookie("rememberPassword",password);
                passwordCookie.setMaxAge(7*24*60*60);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);

            }
            out.println("登陆成功,三秒后跳转到成功页面,如果未跳转请点<a href='"+request.getContextPath()+"/'>这里</a>");
            request.getSession().setAttribute("userStatus",true);
            request.getSession().setAttribute("user",user);
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/");
        }else {
            out.println("用户名和密码错误,请点击<a href='"+request.getContextPath()+"/login'>重试</a>");
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/login");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("rememberUsername")){
                request.setAttribute("rememberUsername",cookie.getValue());
            }
            if(cookie.getName().equals("rememberPassword")){
                request.setAttribute("rememberPassword",cookie.getValue());
            }
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request,response);
        }
    }
}
