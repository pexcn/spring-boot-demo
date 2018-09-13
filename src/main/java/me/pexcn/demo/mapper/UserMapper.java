package me.pexcn.demo.mapper;

import me.pexcn.demo.base.BaseMapper;
import me.pexcn.demo.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    boolean isExistUser(String username);
}
