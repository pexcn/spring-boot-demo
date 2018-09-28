package me.pexcn.demo.config;

import me.pexcn.demo.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author pexcn
 * @date 2018-09-13
 */
@Configuration
public class GlobalConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/login/**")
                .excludePathPatterns(Constants.INTERCEPTOR_EXCLUDE_URLS);
    }
}
