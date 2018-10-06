package me.pexcn.demo.service;

import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.response.LoginResult;
import me.pexcn.demo.entity.response.RegisterResult;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface UserService {
    LoginResult login(User user);

    RegisterResult register(User user);
}
