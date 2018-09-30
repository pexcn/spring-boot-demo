package me.pexcn.demo.interceptor;

import me.pexcn.demo.annotation.Authorization;
import me.pexcn.demo.base.ResponseData;
import me.pexcn.demo.config.Constants;
import me.pexcn.demo.controller.AuthorizationController;
import me.pexcn.demo.entity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author pexcn
 * @date 2018-09-18
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private AuthorizationController authorizationController;

    @Autowired
    public void setAuthorizationController(AuthorizationController authorizationController) {
        this.authorizationController = authorizationController;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            Annotation annotation = method.getDeclaredAnnotation(Authorization.class);
            if (annotation != null) {
                String token = request.getHeader(Constants.HEADER_KEY_AUTHORIZATION);
                ResponseData<User> result = authorizationController.authorization(token);
                if (result.isSuccess()) {
                    request.setAttribute(Constants.REQUEST_KEY_CURRENT_USER, result.getData());
                    return true;
                }
                return false;
            }
        }

        return true;
    }
}
