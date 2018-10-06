package me.pexcn.demo.service.impl;

import me.pexcn.demo.entity.model.Comment;
import me.pexcn.demo.exception.ServiceException;
import me.pexcn.demo.mapper.CommentMapper;
import me.pexcn.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

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
        int code = commentMapper.insert(comment);
        if (code < 1) {
            throw new ServiceException("评论失败");
        }
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        Example example = Example.builder(Comment.class).build();
        example.createCriteria().andEqualTo("userId", userId);
        return commentMapper.selectByExample(example);
    }
}
