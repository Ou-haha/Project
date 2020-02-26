package com.ou.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ou.bean.CommentUser;
import com.ou.bean.Community;
import com.ou.bean.Invitation;
import com.ou.bean.InvitationUser;
import com.ou.service.CommentService;
import com.ou.service.CommunityService;
import com.ou.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class InvitationController {

    @Autowired
    @Qualifier("invitationServiceImpl")
    private InvitationService invitationService;

    @Autowired
    @Qualifier("commentServiceImpl")
    private CommentService commentService;

    @Autowired
    @Qualifier("communityServiceImpl")
    private CommunityService communityService;

    @RequestMapping(method = RequestMethod.GET,value = "/invitation/{id}")
    public String toInvitation(Model model,
                               @PathVariable("id") Integer invitationId,
                               @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                               @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        InvitationUser invitation = invitationService.getInvitationUserById(invitationId);
        Community community = communityService.getCommunityById(invitation.getCommunityId());
        PageInfo<CommentUser> comments = commentService.getCommentUser(invitationId, pageIndex, pageSize);
        model.addAttribute("invitation", invitation);
        model.addAttribute("community", community);
        model.addAttribute("comments", comments);
        return "invitation";
    }

    @RequestMapping(method = RequestMethod.POST, value = "publishInvitation")
    @ResponseBody
    public String string(Invitation invitation){
        return JSON.toJSONString(invitationService.publishInvitation(invitation));
    }
}
