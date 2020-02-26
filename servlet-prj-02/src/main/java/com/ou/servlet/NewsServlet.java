package com.ou.servlet;

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
import java.util.List;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");
    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer newsId = Integer.valueOf(request.getParameter("newsId"));
        News news = newsService.getNewsById(newsId);
        if (news == null){
            request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
        }else {
            List<NewsCate> allCate = newsCateService.getAllCate();
            request.setAttribute("news", news);
            request.setAttribute("allCate", allCate);
            request.getRequestDispatcher("/WEB-INF/view/news.jsp").forward(request,response);
        }
    }
}
