package me.pexcn.demo.service;

import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.entity.request.UserLoginBody;
import me.pexcn.demo.entity.response.UserLoginResponse;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface UserService {
    ResponseData<UserLoginResponse> login(UserLoginBody body);
}
