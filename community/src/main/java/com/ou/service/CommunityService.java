package com.ou.service;

import com.ou.bean.Community;

import java.util.List;

public interface CommunityService {

    //获取热门社区
    List<Community> getTopCommunity();
    //通过社区id获取社区
    Community getCommunityById(int communityId);
    //模糊查询社区
    List<Community> getCommunities(String name);

}