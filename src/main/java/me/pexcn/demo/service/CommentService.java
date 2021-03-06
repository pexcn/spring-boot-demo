package me.pexcn.demo.service;

import me.pexcn.demo.entity.model.Comment;

import java.util.List;

/**
 * @author pexcn
 * @date 2018-09-30
 */
public interface CommentService {
    void addComment(Long userId, Long pathUserId, Comment comment);

    void updateComment(Comment comment);

    List<Comment> getCommentListByUserId(Long userId);
}
