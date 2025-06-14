package com.example.springhttpdemo.httputils;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class MyCustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // initialized only once.
        log.info(">>> initialize MyCustomFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // This is invoked everytime the application receives a HttpServletRequest

        log.info(">>> doFilter");
        // do something before the rest of the application
        // ...

        // invoke the rest of the application
        filterChain.doFilter(servletRequest, servletResponse);

        // do something after the rest of the application
        // ...
    }

    @Override
    public void destroy() {
        // destroyed when the application is shut down.
        log.info(">>> destroy MyCustomFilter");
    }
}
