package com.ou.servlet.manage;

import com.ou.entity.NewsVo;
import com.ou.entity.Page;
import com.ou.factory.ServiceFactory;
import com.ou.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/manage/news")
public class NewsServlet extends HttpServlet {
    
    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageIndex = request.getParameter("pageIndex") == null ? 1 : Integer.valueOf(request.getParameter("pageIndex"));
        int pageSize = 10;
        Page<NewsVo> newsVoPage = newsService.getNewsVoPage(pageIndex, pageSize);
        if(newsVoPage.getBeanList() == null || newsVoPage.getBeanList().isEmpty()){
            request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request,response);
        }else {
            request.setAttribute("newsVoPage", newsVoPage);
            request.getRequestDispatcher("/WEB-INF/view/admin/manage/news.jsp").forward(request, response);
        }
    }
}
