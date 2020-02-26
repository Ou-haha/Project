package com.ou.service;

import com.github.pagehelper.PageInfo;
import com.ou.bean.Comment;
import com.ou.bean.CommentUser;

import java.util.Map;

public interface CommentService {

    PageInfo<CommentUser> getCommentUserByCinId(int cinId, int pageIndex, int pageSize);

    PageInfo<CommentUser> getCommentUser(int InvitationId, int pageIndex, int pageSize);

    Map<String, Object> publishComment(Comment comment);

}
