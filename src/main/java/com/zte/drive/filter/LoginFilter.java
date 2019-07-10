//package com.zte.drive.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * Author:helloboy
// * Date:2019-07-08 16:28
// * Description:<描述>
// */
//@WebFilter(filterName = "LoginFilter")
//public class LoginFilter implements Filter {
//    @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//                // TODO Auto-generated method stub
//            }
//            @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//            FilterChain chain) throws IOException, ServletException {
//                // 获得在下面代码中要用的request,response,session对象
//                HttpServletRequest servletRequest = (HttpServletRequest) request;
//                HttpServletResponse servletResponse = (HttpServletResponse) response;
//                HttpSession session = servletRequest.getSession();
//                // 获得用户请求的URI
//                String path = servletRequest.getRequestURI();
//
//                // 从session里取员工工号信息
//                 String admin = (String) session.getAttribute("admin");
//
//
//                 // 登陆页面无需过滤
//               if(path.indexOf("/login.jsp") > -1) {
//                        chain.doFilter(servletRequest, servletResponse);
//                        return;
//                     }
//
//                // 判断如果没有取到员工信息,就跳转到登陆页面
//                if (admin == null || "".equals(admin)) {
//                         // 跳转到登陆页面
//                         servletResponse.sendRedirect("/WEB-INF/admin/login.jsp");
//                     } else {
//                         // 已经登陆,继续此次请求
//                         chain.doFilter(request, response);
//                     }
//             }
//             @Override
//    public void destroy() {
//                // TODO Auto-generated method stub
//             }
//         }
//
