package me.pexcn.demo.service;

import me.pexcn.demo.entity.model.User;

/**
 * @author pexcn
 * @date 2018-09-28
 */
public interface AuthorizationService {
    User authorization(String token);
}
