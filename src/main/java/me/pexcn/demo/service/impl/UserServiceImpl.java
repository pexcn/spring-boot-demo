package me.pexcn.demo.service.impl;

import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.response.LoginResult;
import me.pexcn.demo.entity.response.RegisterResult;
import me.pexcn.demo.exception.CommonException;
import me.pexcn.demo.mapper.UserMapper;
import me.pexcn.demo.service.UserService;
import me.pexcn.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public LoginResult login(User user) {
        if ("".equals(user.getUsername()) || Objects.isNull(user.getUsername())) {
            throw new CommonException(ErrorCode.USERNAME_NOT_BE_NULL);
        }

        if ("".equals(user.getPassword()) || Objects.isNull(user.getPassword())) {
            throw new CommonException(ErrorCode.PASSWORD_NOT_BE_NULL);
        }

        if (!userMapper.isExistUser(user.getUsername())) {
            throw new CommonException(ErrorCode.USER_NOT_EXIST);
        }

        User u = userMapper.selectOne(user);
        if (Objects.isNull(u)) {
            throw new CommonException(ErrorCode.USER_NOT_MATCH);
        }

        LoginResult result = new LoginResult();
        result.setUserId(u.getUid());
        result.setToken(TokenUtils.createToken(u));
        return result;
    }

    @Override
    public RegisterResult register(User user) {
        if ("".equals(user.getUsername()) || Objects.isNull(user.getUsername())) {
            throw new CommonException(ErrorCode.USERNAME_NOT_BE_NULL);
        }

        if ("".equals(user.getPassword()) || Objects.isNull(user.getPassword())) {
            throw new CommonException(ErrorCode.PASSWORD_NOT_BE_NULL);
        }

        if (userMapper.isExistUser(user.getUsername())) {
            throw new CommonException(ErrorCode.USER_ALREADY_EXIST);
        }

        int code = userMapper.insertSelective(user);
        if (code < 1) {
            throw new CommonException("注册失败");
        }

        RegisterResult result = new RegisterResult();
        result.setUserId(user.getUid());
        result.setToken(TokenUtils.createToken(user));
        return result;
    }
}
