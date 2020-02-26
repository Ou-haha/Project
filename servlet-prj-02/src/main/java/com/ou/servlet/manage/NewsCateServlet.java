package com.ou.servlet.manage;

import com.ou.entity.NewsCate;
import com.ou.factory.ServiceFactory;
import com.ou.service.NewsCateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/manage/newsCate")
public class NewsCateServlet extends HttpServlet {

    private NewsCateService newsCateService = (NewsCateService) ServiceFactory.getService("NewsCateService");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NewsCate> allCate = newsCateService.getAllCate();
        request.setAttribute("allCate",allCate);
        request.getRequestDispatcher("/WEB-INF/view/admin/manage/newsCate.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (request.getParameter("method") != null && request.getParameter("method").equals("insert")) {
            insert(request, response, out);
        } else if (request.getParameter("name") != null) {
            update(request, response, out);
        } else {
            delete(request, response, out);
        }
        response.setHeader("refresh", "2;url=" + request.getContextPath() + "/admin/manage/newsCate");

    }

    private void insert(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String name = request.getParameter("name");
        NewsCate newsCate = new NewsCate();
        newsCate.setName(name);
        int insertCount = newsCateService.insert(newsCate);
        if (insertCount > 0) {
            out.println("添加成功,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        } else {
            out.println("添加失败,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String id = request.getParameter("id");
        int deleteCount = newsCateService.delete(Integer.valueOf(id));
        if (deleteCount > 0) {
            out.println("删除成功,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        } else {
            out.println("删除失败,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String name = request.getParameter("name");
        Integer id = Integer.valueOf(request.getParameter("id"));
        NewsCate newsCate = new NewsCate();
        newsCate.setId(id);
        newsCate.setName(name);
        int updateCount = newsCateService.update(newsCate);
        if (updateCount > 0) {
            out.println("修改成功,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        } else {
            out.println("修改失败,三秒后跳转到管理页面，若未跳转请点<a href='" + request.getContextPath() + "/admin/manage/newsCate'>这里</a>");
        }


    }
}
