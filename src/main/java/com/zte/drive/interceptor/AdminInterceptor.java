package com.zte.drive.interceptor;

import com.zte.drive.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Author:helloboy
 * Date:2019-07-09 9:19
 * Description:<描述>
 */
public class AdminInterceptor implements HandlerInterceptor {
        /**
         * Handler执行完成之后调用这个方法
         */
        @Override
        public void afterCompletion(HttpServletRequest request,
                                    HttpServletResponse response, Object handler, Exception exc)
                throws Exception {

        }

        /**
         * Handler执行之后，ModelAndView返回之前调用这个方法
         */
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response,
                               Object handler, ModelAndView modelAndView) throws Exception {
        }

        /**
         * Handler执行之前调用这个方法
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                 Object handler) throws Exception {
            //获取请求的URL
            // String url = request.getRequestURI();
            //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
//        if(url.indexOf("login.action")>=0){
//            return true;
//        }
            //获取Session
            HttpSession session = request.getSession();
            Admin admin = (Admin)session.getAttribute("admin");
//        System.out.print(uid);
            if(admin != null){
                return true;
            }
            //不符合条件的，跳转到登录界面
            response.sendRedirect(request.getContextPath()+"/admin/login");

            return false;
        }

}