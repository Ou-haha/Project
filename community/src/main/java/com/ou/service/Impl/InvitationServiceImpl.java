package com.ou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ou.bean.Invitation;
import com.ou.bean.InvitationUser;
import com.ou.bean.InvitationUserCommunity;
import com.ou.mapper.InvitationMapper;
import com.ou.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    private InvitationMapper invitationMapper;

    public void setInvitationMapper(InvitationMapper invitationMapper) {
        this.invitationMapper = invitationMapper;
    }

    @Override
    public Map<String, Object> publishInvitation(Invitation invitation) {

            invitation.setTime(new Date());
            Map<String, Object> map = new HashMap<>();
            if (invitationMapper.insert(invitation) > 0) {
                map.put("success", true);
                map.put("message", "发表成功");
            } else {
                map.put("success", false);
                map.put("message", "发表失败");
            }
            return map;

    }

    public List<InvitationUserCommunity> getTopInvitation() {
        return invitationMapper.getTopInvitation();
    }

    public InvitationUser getInvitationUserById(Integer invitationId) {
        return invitationMapper.getInvitationUserById(invitationId);
    }

    public PageInfo<InvitationUser> getInvitationPage(int communityId, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex, pageSize);
        List<InvitationUser> invitationUsers = invitationMapper.getInvitationUsersByCommunityId(communityId);
        return new PageInfo<>(invitationUsers);
    }
}
