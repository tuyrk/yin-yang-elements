package com.cdutcm.elements.adapter;

import com.cdutcm.elements.interceptor.EncodingInterceptor;
import com.cdutcm.elements.interceptor.LoginInterceptor;
import com.cdutcm.elements.interceptor.RoleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * User: 涂元坤
 * Mail: 766564616@qq.com
 * Create: 2018/3/29 15:00 星期四
 * Description:
 */
@Configuration
public class LoginAdapter extends WebMvcConfigurationSupport {
    @Autowired
    public RoleInterceptor roleInterceptor;//用户角色拦截器
    @Autowired
    public EncodingInterceptor encodingInterceptor;//用户登录拦截器
    @Autowired
    public LoginInterceptor loginInterceptor;//用户登录拦截器


    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //用户角色拦截器
        registry.addInterceptor(roleInterceptor).
                addPathPatterns("/**");
        registry.addInterceptor(encodingInterceptor).
                addPathPatterns("/**");
        //用户登录拦截器
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/error").
                excludePathPatterns("/").
                excludePathPatterns("/doctor/manage/sendCode").
                excludePathPatterns("/doctor/manage/regis").
                excludePathPatterns("/doctor/manage/login").
                excludePathPatterns("/doctor/manage/retrieve").
                excludePathPatterns("/css/**").
                excludePathPatterns("/images/**").
                excludePathPatterns("/js/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 添加静态资源路径
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
        registry.addResourceHandler("/img/**").addResourceLocations("file:img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        super.addResourceHandlers(registry);
    }
}
