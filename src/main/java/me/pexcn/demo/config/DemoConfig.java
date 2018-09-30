package me.pexcn.demo.config;

import me.pexcn.demo.extension.CurrentUserArgumentResolver;
import me.pexcn.demo.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author pexcn
 * @date 2018-09-13
 */
@Configuration
public class DemoConfig implements WebMvcConfigurer {
    private AuthorizationInterceptor authorizationInterceptor;
    private CurrentUserArgumentResolver currentUserArgumentResolver;

    @Autowired
    public void setAuthorizationInterceptor(AuthorizationInterceptor interceptor) {
        this.authorizationInterceptor = interceptor;
    }

    @Autowired
    public void setCurrentUserArgumentResolver(CurrentUserArgumentResolver resolver) {
        this.currentUserArgumentResolver = resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(Constants.INTERCEPTOR_EXCLUDE_URLS);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(currentUserArgumentResolver);
    }
}
