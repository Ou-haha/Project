package com.ou.servlet;

import com.ou.entity.NewsCate;
import com.ou.entity.NewsCateVo;
import com.ou.factory.ServiceFactory;
import com.ou.service.NewsCateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.setAttribute("allCate",allCate);
        List<NewsCateVo> allNewsCateVo = newsCateService.getAllNewsCateVo(5);
        request.setAttribute("allNewsCateVo",allNewsCateVo);
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request,response);
    }
}
