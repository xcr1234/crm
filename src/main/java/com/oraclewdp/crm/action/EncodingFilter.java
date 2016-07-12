package com.oraclewdp.crm.action;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author xcr
 */
public class EncodingFilter implements Filter {

    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        System.out.println("执行到了编码过滤器");
    }

    @Override
    public void destroy() {

    }
}
