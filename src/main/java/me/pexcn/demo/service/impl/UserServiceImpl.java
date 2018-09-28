package me.pexcn.demo.service.impl;

import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.request.UserLoginBody;
import me.pexcn.demo.entity.response.UserLoginResponse;
import me.pexcn.demo.exception.GlobalException;
import me.pexcn.demo.mapper.UserMapper;
import me.pexcn.demo.service.UserService;
import me.pexcn.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Objects;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserLoginResponse login(UserLoginBody body) {
        if ("".equals(body.getUsername()) || Objects.isNull(body.getUsername())) {
            throw new GlobalException(ErrorCode.USERNAME_NOT_BE_NULL);
        }

        if ("".equals(body.getPassword()) || Objects.isNull(body.getPassword())) {
            throw new GlobalException(ErrorCode.PASSWORD_NOT_BE_NULL);
        }

        if (!userMapper.isExistUser(body.getUsername())) {
            throw new GlobalException(ErrorCode.USER_NOT_EXIST);
        }

        User user = findUser(body);
        if (Objects.isNull(user)) {
            throw new GlobalException(ErrorCode.USER_NOT_MATCH);
        }

        UserLoginResponse info = new UserLoginResponse();
        info.setUser(user);
        info.setToken(TokenUtils.createToken(user));
        return info;
    }

    private User findUser(UserLoginBody body) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("username", body.getUsername())
                .andEqualTo("password", body.getPassword());
        return userMapper.selectOneByExample(example);
    }
}
