package com.ou.service;


import com.github.pagehelper.PageInfo;
import com.ou.bean.Invitation;
import com.ou.bean.InvitationUser;
import com.ou.bean.InvitationUserCommunity;

import java.util.List;
import java.util.Map;

public interface InvitationService {

    //发表帖子
    Map<String, Object> publishInvitation(Invitation invitation);

    //获取热门帖子，封装为InvitationUserCommunity结果集
    List<InvitationUserCommunity> getTopInvitation();

    //通过帖子的ID获得帖子的信息（包含评论帖子的用户名）
    InvitationUser getInvitationUserById(Integer invitationId);

    //通过社区的ID获得帖子的信息（包含评论帖子的用户名）
    PageInfo<InvitationUser> getInvitationPage(int communityId, int pageIndex, int pageSize);

}
