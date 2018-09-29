package me.pexcn.demo.config;

import me.pexcn.demo.interceptor.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author pexcn
 * @date 2018-09-13
 */
@Configuration
public class GlobalConfig implements WebMvcConfigurer {
    private AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    public void setAuthorizationInterceptor(AuthorizationInterceptor interceptor) {
        this.authorizationInterceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(Constants.INTERCEPTOR_EXCLUDE_URLS);
    }
}
