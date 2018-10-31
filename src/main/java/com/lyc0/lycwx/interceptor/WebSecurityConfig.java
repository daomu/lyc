package com.lyc0.lycwx.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Resource
    private LoginHandlerInterceptor loginHandlerInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(loginHandlerInterceptor);

        // 排除配置
        addInterceptor.excludePathPatterns("/wx/error");
        addInterceptor.excludePathPatterns("/wx/login**");

        // 拦截配置
        addInterceptor.addPathPatterns("/wx/**");
    }

}
