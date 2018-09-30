package me.pexcn.demo.service.impl;

import me.pexcn.demo.entity.model.Comment;
import me.pexcn.demo.exception.StatusException;
import me.pexcn.demo.mapper.CommentMapper;
import me.pexcn.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author pexcn
 * @date 2018-09-30
 */
@Service
public class CommentServiceImpl implements CommentService {
    private CommentMapper commentMapper;

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public void addComment(Long userId, Comment comment) {
        comment.setUserId(userId);
        comment.setCreatedTime(new Date());
        int result = commentMapper.insert(comment);
        if (result < 1) {
            throw new StatusException("评论失败");
        }
    }
}
