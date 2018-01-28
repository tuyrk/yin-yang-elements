package com.cdutcm.interceptor;

import com.cdutcm.entity.Doctor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class DoctorInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取会话里面登陆的用户信息
        Doctor doctor = (Doctor) httpServletRequest.getSession().getAttribute("doctor");
        if (doctor == null) {
            httpServletResponse.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print("<head><meta charset=\"UTF-8\"><script>alert(\"您尚未登录!\");window.location = \"" + httpServletRequest.getContextPath() + "\";</script></head>");
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
