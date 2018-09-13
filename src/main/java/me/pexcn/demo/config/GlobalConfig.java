package me.pexcn.demo.config;

import me.pexcn.demo.interceptor.AnnotationInterceptor;
import me.pexcn.demo.interceptor.UserInterceptor;
import me.pexcn.demo.extension.TimestampArgumentResolver;
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
public class GlobalConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AnnotationInterceptor())
                .addPathPatterns("/demo/**")
                .excludePathPatterns(Constants.INTERCEPTOR_EXCLUDE_URLS);
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/login/**")
                .excludePathPatterns(Constants.INTERCEPTOR_EXCLUDE_URLS);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TimestampArgumentResolver());
    }
}
