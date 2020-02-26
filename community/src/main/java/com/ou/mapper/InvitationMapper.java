package com.ou.mapper;

import com.ou.bean.Invitation;
import com.ou.bean.InvitationUser;
import com.ou.bean.InvitationUserCommunity;

import java.util.List;

public interface InvitationMapper extends BaseMapper<Invitation>{

    //添加帖子
    int insert(Invitation invitation);

    //获取热门帖子，封装为InvitationUserCommunity结果集
    List<InvitationUserCommunity> getTopInvitation();

    //通过帖子的ID获得帖子的信息（包含评论帖子的用户名）
    InvitationUser getInvitationUserById(int invitationId);

    //通过社区的ID获得帖子的信息（包含评论帖子的用户名）
    List<InvitationUser> getInvitationUsersByCommunityId(int communityId);
}
