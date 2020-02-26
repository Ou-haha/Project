package com.ou.servlet.manage;

import com.ou.entity.Admin;
import com.ou.entity.News;
import com.ou.entity.NewsCate;
import com.ou.factory.ServiceFactory;
import com.ou.service.NewsCateService;
import com.ou.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


@WebServlet("/admin/manage/publish")
public class PublishServlet extends HttpServlet {

    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");
    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<NewsCate> allCate = newsCateService.getAllCate();
        if (allCate == null||allCate.isEmpty()){
            request.getRequestDispatcher("WEB-INF/view/error/error.jsp").forward(request,response);
        }else {
            request.setAttribute("allCate", allCate);
            request.getRequestDispatcher("/WEB-INF/view/admin/manage/publish.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        News news = new News();
        news.setContent(request.getParameter("content"));
        news.setAuthor(admin.getUsername());
        news.setCateId(Integer.valueOf(request.getParameter("cate")));
        news.setTitle(request.getParameter("title"));
        news.setTime(new Date());
        int publish = newsService.publish(news);
        if (publish>0){
            out.println("发布成功,三秒后跳转到发布页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/publish'>这里</a>");
        }else{
            out.println("发布失败,三秒后跳转到发布页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/publish'>这里</a>");
        }
        response.setHeader("refresh","2;url="+request.getContextPath()+"/admin/manage/publish");
    }
}
