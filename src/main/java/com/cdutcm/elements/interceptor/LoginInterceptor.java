package com.cdutcm.elements.interceptor;

import com.cdutcm.elements.entity.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // TODO: 2018/5/14 发布时删除
//        httpServletRequest.getSession().setAttribute("doctor", new Doctor(null,"tyk","123456","涂元坤","766564616@qq.com",1));
        //获取会话里面登陆的用户信息
        if (httpServletRequest.getSession().getAttribute("doctor") == null) {
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print("<head><meta charset=\"UTF-8\"><script>alert(\"您尚未登录!\");window.location = \"/\";</script></head>");
            printWriter.flush();
            printWriter.close();
        }
        return true;//让下一个拦截器去处理
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
