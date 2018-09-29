package me.pexcn.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.entity.model.User;
import me.pexcn.demo.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pexcn
 * @date 2018-09-28
 */
@RestController
@RequestMapping("/authorization")
@Api(value = "/authorization", tags = "授权接口", description = "用于权限验证")
public class AuthorizationController {
    private AuthorizationService authorizationService;

    @Autowired
    public void setAuthorizationService(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping
    @ApiOperation(value = "授权")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", dataType = "String", paramType = "header", required = true)
    })
    public ResponseData<User> authorization(@RequestHeader String token) {
        User user = authorizationService.authorization(token);
        return ResponseData.succeed(user);
    }
}
