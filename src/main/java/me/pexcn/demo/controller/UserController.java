package me.pexcn.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.entity.request.UserLoginBody;
import me.pexcn.demo.entity.response.UserLoginResponse;
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
@Slf4j
@Api(value = "/user", tags = "用户接口", description = "用户登录注册接口")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "body", value = "登录信息", dataTypeClass = User.class, paramType = "body", required = true)
    })
    public ResponseData<UserLoginResponse> login(@RequestBody UserLoginBody body) {
        UserLoginResponse response = userService.login(body);
        return ResponseData.succeed(response);
    }
}
