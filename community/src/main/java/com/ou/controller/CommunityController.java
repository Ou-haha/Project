package com.ou.controller;


import com.github.pagehelper.PageInfo;
import com.ou.bean.Community;
import com.ou.bean.InvitationUser;
import com.ou.bean.InvitationUserCommunity;
import com.ou.service.CommunityService;
import com.ou.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommunityController {

    @Autowired
    @Qualifier("communityServiceImpl")
    private CommunityService communityService;

    @Autowired
    @Qualifier("invitationServiceImpl")
    private InvitationService invitationService;


    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String Index(Model model){

        List<Community> topCommunity = communityService.getTopCommunity();
        List<InvitationUserCommunity> topInvitation = invitationService.getTopInvitation();
        model.addAttribute("topCommunity",topCommunity);
        model.addAttribute("topInvitation",topInvitation);
        return "index";

    }

    @RequestMapping("/search")
    public String searchCommunity(HttpServletRequest request,Model model){

        List<Community> communities = communityService.getCommunities(request.getParameter("name"));
        model.addAttribute("communities",communities);
        return "search";
    }

    /**
     * @RequestParam：将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
     * required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
     */
    @RequestMapping("/community/{id}")
    public String toCommunity(
            Model model,
            @PathVariable("id") Integer communityId,
            @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false,defaultValue = "10") Integer pageSize){

        PageInfo<InvitationUser> invitationPage = invitationService.getInvitationPage(communityId, pageIndex, pageSize);
        Community community = communityService.getCommunityById(communityId);
        model.addAttribute("community",community);
        model.addAttribute("invitationPage",invitationPage);
        return "community";

    }
}
