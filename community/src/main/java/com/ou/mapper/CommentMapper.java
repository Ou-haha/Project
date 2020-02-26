package com.ou.mapper;

import com.ou.bean.Comment;
import com.ou.bean.CommentUser;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    //添加评论
    int insert(Comment comment);

    //通过帖子获得评论用户所有信息
    List<CommentUser> getCommentByInvitationId(Integer InvitationId);

    //通过CinId获取发表评论的用户信息
    List<CommentUser> getCommentByCinId(int cinId);

}
