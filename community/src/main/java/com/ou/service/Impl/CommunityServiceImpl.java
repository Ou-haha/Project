package com.ou.service.Impl;

import com.ou.bean.Community;
import com.ou.mapper.CommunityMapper;
import com.ou.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    public void setCommunityMapper(CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    public List<Community> getTopCommunity() {
        return communityMapper.getTopCommunity();
    }

    public Community getCommunityById(int communityId) {
        return communityMapper.getById(communityId);
    }

    public List<Community> getCommunities(String name) {
        return communityMapper.getCommunityLikeName(name);
    }
}
