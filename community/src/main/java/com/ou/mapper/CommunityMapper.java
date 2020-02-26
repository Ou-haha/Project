package com.ou.mapper;


import com.ou.bean.Community;

import java.util.List;

public interface CommunityMapper extends BaseMapper<Community>{

    //查询最热门的六个社区
    List<Community> getTopCommunity();

    //通过社区id获取社区
    Community getById(int id);

    //通过查找相似社区名字段查找社区
    List<Community> getCommunityLikeName(String name);

}
