package com.ou.servlet;

import com.ou.entity.News;
import com.ou.entity.NewsCate;
import com.ou.entity.Page;
import com.ou.factory.ServiceFactory;
import com.ou.service.NewsCateService;
import com.ou.service.NewsService;
import com.ou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");
    private NewsService newsService = (NewsService) ServiceFactory.getService("NewsService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取新闻类目的对应ID
        Integer cateId = Integer.valueOf(request.getParameter("cateId"));
        //根据获取到的ID获取对应的类目对象
        NewsCate newsCate = newsCateService.getNewsCateById(cateId);
        //判断类目对象是否存在，不存在返回错误页面，若继续执行
        if (newsCate == null){
            request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
        }else {
            //获取网页当前的页面页码
            int pageIndex = request.getParameter("pageIndex") == null ? 1: Integer.valueOf(request.getParameter("pageIndex"));
            //设置展现页的展现条数
            int pageSize = 10;
            //获取封装分页结果集
            Page<News> newsPage = newsService.getNewsPageByCate(cateId, pageIndex, pageSize);
            //判断封装分页结果集是否存在
            if (newsPage.getBeanList() == null || newsPage.getBeanList().isEmpty()){
                request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
            }
            //将封装分页结果集响应回页面
            request.setAttribute("newsPage",newsPage);
            request.setAttribute("cate",newsCate);
            //补充头文件需要的allCate
            List<NewsCate> allCate = newsCateService.getAllCate();
            request.setAttribute("allCate",allCate);
            request.getRequestDispatcher("/WEB-INF/view/newsCate.jsp").forward(request,response);
        }


    }

}
