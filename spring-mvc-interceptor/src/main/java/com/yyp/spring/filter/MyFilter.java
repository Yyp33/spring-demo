package com.yyp.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/**")//将过滤器注入到spring容器并拦截所有的请求
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-----------过滤器方法执行前-------------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("-----------过滤器方法执行后-------------");
    }

    public void destroy() {

    }
}
