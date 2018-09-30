package me.pexcn.demo.mapper;

import me.pexcn.demo.base.BaseMapper;
import me.pexcn.demo.entity.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author pexcn
 * @date 2018-09-30
 */
@Repository
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
