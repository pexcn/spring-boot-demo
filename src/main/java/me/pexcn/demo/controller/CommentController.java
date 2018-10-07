package me.pexcn.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.pexcn.demo.annotation.Authorization;
import me.pexcn.demo.annotation.CurrentUser;
import me.pexcn.demo.utils.ResponseData;
import me.pexcn.demo.config.Constants;
import me.pexcn.demo.entity.model.Comment;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.request.CommentBody;
import me.pexcn.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author pexcn
 * @date 2018-09-30
 */
@RestController
@RequestMapping("/comments")
@Api(value = "/comment", tags = "评论接口", description = "用户评论相关接口")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Authorization
    @PostMapping
    @ApiOperation("添加评论")
    @ApiImplicitParam(name = Constants.HEADER_KEY_AUTHORIZATION, value = "Token", dataType = "String", paramType = "header", required = true)
    public ResponseData<?> addComment(@ApiIgnore @CurrentUser User user, @RequestBody CommentBody body) {
        Comment comment = new Comment();
        comment.setCommentText(body.getComment());
        commentService.addComment(user.getUid(), comment);
        return ResponseData.succeed();
    }

    @Authorization
    @GetMapping
    @ApiOperation("根据用户 ID 获取评论")
    @ApiImplicitParam(name = Constants.HEADER_KEY_AUTHORIZATION, value = "Token", dataType = "String", paramType = "header", required = true)
    public ResponseData<List<Comment>> getCommentsByUserId(@ApiIgnore @CurrentUser User user) {
        Long uid = user.getUid();
        List<Comment> comments = commentService.getCommentsByUserId(uid);
        return ResponseData.succeed(comments);
    }
}
