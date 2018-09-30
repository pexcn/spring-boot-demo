package me.pexcn.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.request.LoginBody;
import me.pexcn.demo.entity.response.LoginResult;
import me.pexcn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户接口", description = "用户登录注册接口")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResponseData<LoginResult> login(@RequestBody LoginBody body) {
        User user = new User();
        user.setUsername(body.getUsername());
        user.setPassword(body.getPassword());
        LoginResult result = userService.login(user);
        return ResponseData.succeed(result);
    }
}
