package me.pexcn.demo.service.impl;

import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.entity.request.UserLoginBody;
import me.pexcn.demo.mapper.UserMapper;
import me.pexcn.demo.entity.response.UserLoginResponse;
import me.pexcn.demo.entity.model.User;
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
    public ResponseData<UserLoginResponse> login(UserLoginBody body) {
        if ("".equals(body.getUsername()) || Objects.isNull(body.getUsername())) {
            return ResponseData.fail(ErrorCode.USERNAME_NOT_BE_NULL, "Username cannot be null.");
        }

        if ("".equals(body.getPassword()) || Objects.isNull(body.getPassword())) {
            return ResponseData.fail(ErrorCode.PASSWORD_NOT_BE_NULL, "Password cannot be null.");
        }

        if (!userMapper.isExistUser(body.getUsername())) {
            return ResponseData.fail(ErrorCode.USER_NOT_EXIST, "User not exist.");
        }

        User user = findUser(body);
        if (Objects.isNull(user)) {
            return ResponseData.fail(ErrorCode.USER_NOT_MATCH, "Password not matched.");
        }

        UserLoginResponse info = new UserLoginResponse();
        info.setUser(user);
        info.setToken(TokenUtils.createToken(user));
        return ResponseData.succeed(info);
    }

    private User findUser(UserLoginBody body) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("username", body.getUsername())
                .andEqualTo("password", body.getPassword());
        return userMapper.selectOneByExample(example);
    }
}