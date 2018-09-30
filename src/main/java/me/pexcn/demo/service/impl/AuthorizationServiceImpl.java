package me.pexcn.demo.service.impl;

import io.jsonwebtoken.Claims;
import me.pexcn.demo.config.Constants;
import me.pexcn.demo.config.ErrorCode;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.exception.ServiceException;
import me.pexcn.demo.mapper.UserMapper;
import me.pexcn.demo.service.AuthorizationService;
import me.pexcn.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author pexcn
 * @date 2018-09-28
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User authorization(String token) {
        if (!TokenUtils.isValid(token)) {
            throw new ServiceException(ErrorCode.TOKEN_INVALID);
        }

        Claims claims = TokenUtils.parseToken(token);
        Long uid = Long.valueOf(claims.get(Constants.TOKEN_KEY_UID).toString());
        User user = new User();
        user.setUid(uid);
        return userMapper.selectOne(user);
    }
}
