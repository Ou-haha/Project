package com.ou.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ou.bean.Comment;
import com.ou.bean.CommentUser;
import com.ou.mapper.CommentMapper;
import com.ou.mapper.UserMapper;
import com.ou.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public PageInfo<CommentUser> getCommentUserByCinId(int cinId, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<CommentUser> commentUsers = commentMapper.getCommentByCinId(cinId);

        return new PageInfo<CommentUser>(commentUsers);
    }

    public PageInfo<CommentUser> getCommentUser(int InvitationId, int pageIndex, int pageSize) {

        PageHelper.startPage(pageIndex,pageSize);
        List<CommentUser> comments = commentMapper.getCommentByInvitationId(InvitationId);

        return new PageInfo<CommentUser>(comments);
    }

    public Map<String, Object> publishComment(Comment comment) {
        comment.setTime(new Date());
        Map<String, Object> map = new HashMap<>();
        try {
            if (commentMapper.insert(comment) > 0) {
                map.put("success", true);
                map.put("message", "评论成功");
                return map;
            } else {
                map.put("success", false);
                map.put("message", "评论失败");
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
