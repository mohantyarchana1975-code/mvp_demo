package com.demo.mvp;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
class TokenInterceptor implements HandlerInterceptor {
    @Autowired UserRepo users;
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String path = req.getRequestURI();
        if (path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui") || path.startsWith("/api/auth") || path.equals("/api/health")) return true;
        String token = req.getHeader("X-Token");
        if (token==null || users.findByToken(token).isEmpty()) {
            res.setStatus(401);
            res.getWriter().write("Unauthorized");
            return false;
        }
        return true;
    }
}

@Component
class WebConfig implements WebMvcConfigurer {
    private final TokenInterceptor interceptor;
    WebConfig(TokenInterceptor i){this.interceptor=i;}
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}
