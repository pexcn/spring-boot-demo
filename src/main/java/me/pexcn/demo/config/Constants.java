package me.pexcn.demo.config;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public interface Constants {
    String[] INTERCEPTOR_EXCLUDE_URLS = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/csrf",
            "/error",
            "/"
    };

    String SWAGGER_BASE_API_PACKAGE = "me.pexcn.demo";

    String TOKEN_KEY_UID = "uid";
}
