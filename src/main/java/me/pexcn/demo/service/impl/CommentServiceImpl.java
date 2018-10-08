package me.pexcn.demo.service.impl;

import me.pexcn.demo.entity.model.Comment;
import me.pexcn.demo.exception.CommonException;
import me.pexcn.demo.mapper.CommentMapper;
import me.pexcn.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public void addComment(Long userId, Long pathUserId, Comment comment) {
        if (!userId.equals(pathUserId)) {
            throw new CommonException("API 路径的 ID 要与已登录的用户 ID 一致");
        }

        int code = commentMapper.insert(comment);
        if (code < 1) {
            throw new CommonException("评论失败");
        }
    }

    @Override
    public void updateComment(Comment comment) {
        int code = commentMapper.updateByPrimaryKeySelective(comment);
        if (code < 1) {
            throw new CommonException("更新评论失败");
        }
    }

    @Override
    public List<Comment> getCommentListByUserId(Long userId) {
        Example example = new Example(Comment.class);
        example.createCriteria().andEqualTo("userId", userId);
        return commentMapper.selectByExample(example);
    }
}
