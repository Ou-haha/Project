package com.ou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ou.bean.User;
import com.ou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    /**
     * 跳转到登录页面
     */
    @RequestMapping(method = RequestMethod.GET,value = "login")
    public String toLogin(HttpServletRequest request, Model model){

        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("rememberUsername")) {
                    model.addAttribute(cookie.getName(), cookie.getValue());
                }
                if (cookie.getName().equals("rememberPassword")) {
                    model.addAttribute(cookie.getName(), cookie.getValue());
                }
            }
        }
        return "login";
    }

    /**
     * 跳转到注册界面
     */
    @RequestMapping(method = RequestMethod.GET,value = "register")
    public String toRegister(){
        return "register";
    }
    /**
     * 登录功能
     * produces = "text/html;charset=UTF-8" 设置返回数据字符集
     * ResponseBody注解返回字符串，非返回视图
     */
    @RequestMapping(method = RequestMethod.POST,value = "login.do")
    @ResponseBody
    public String login(String username,String password, String remember,HttpServletRequest request, HttpServletResponse response,Model model){

        Map<String, Object> map = userService.login(username, password);

        if ((Boolean)map.get("success")){
            // 保存cookie
            if (remember!=null&&remember.equals("on")){
                Cookie usernameCookie = new Cookie("rememberUsername",username);
                Cookie passwordCookie = new Cookie("rememberPassword", password);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
            request.getSession().setAttribute("userStatus", true);
            request.getSession().setAttribute("username", map.get("username"));
            request.getSession().setAttribute("userId", map.get("userId"));
        }
        return JSON.toJSONString(map);
    }

    /**
     * 注册用户功能
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "register.do")
    @ResponseBody
    public String register(User user){
        return JSON.toJSONString(userService.register(user));
    }
    /**
     * 登出功能
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value ="logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userStatus");
        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("userId");
        return "login";
    }

}
