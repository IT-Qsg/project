package com.dfec.springbootmybatis.component;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author qsg
 * @version 1.0
 * @Date 2020/7/9 14:27
 * @describe
 **/
@Component
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Remote Host:"+request.getRemoteHost());
        System.out.println("端口："+request.getServerPort());
        System.out.println("Remote Address:"+request.getRemoteAddr());
        filterChain.doFilter(request, response);


    }

    @Override
    public void destroy() {

    }
}
