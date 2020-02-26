package com.ou.controller;

import com.alibaba.fastjson.JSON;
import com.ou.bean.Comment;
import com.ou.service.CommentService;
import com.ou.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST,value = "publishComment")
    @ResponseBody
    public String publish(Comment comment){
        return JSON.toJSONString(commentService.publishComment(comment));
    }

    @RequestMapping(method = RequestMethod.POST,value = "getComments")
    public String getComments(Model model,Integer cinId,
                              @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                              @RequestParam(required = false,defaultValue = "5") Integer pageSize){
        model.addAttribute("comments",commentService.getCommentUserByCinId(cinId,pageIndex,pageSize));
        model.addAttribute("cinId",cinId);
        return "comment";
    }

}
