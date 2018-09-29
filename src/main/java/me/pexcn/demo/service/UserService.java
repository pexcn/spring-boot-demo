package me.pexcn.demo.service;

import me.pexcn.demo.entity.request.LoginInfo;
import me.pexcn.demo.entity.response.LoginResult;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface UserService {
    LoginResult login(LoginInfo body);
}
