package me.pexcn.demo.service;

import me.pexcn.demo.entity.request.UserLoginBody;
import me.pexcn.demo.entity.response.UserLoginResponse;
import org.omg.CORBA.UserException;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface UserService {
    UserLoginResponse login(UserLoginBody body) throws UserException;
}
