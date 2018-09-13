package me.pexcn.demo.interceptor;

import me.pexcn.demo.annotation.CheckAnnotation;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pexcn
 * @date 2018-09-13
 */
public class AnnotationInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            CheckAnnotation annotation = ((HandlerMethod) handler).getMethod().getDeclaredAnnotation(CheckAnnotation.class);
            if (annotation != null) {
                request.setAttribute("annotation", true);
            } else {
                request.setAttribute("annotation", false);
            }
        }
        return super.preHandle(request, response, handler);
    }
}
