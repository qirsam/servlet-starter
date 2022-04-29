package com.qirsam.http.filter;

import com.qirsam.http.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

import static com.qirsam.http.utils.UrlPath.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private static final Set<String> PUBLIC_PATH = Set.of(LOGIN, REGISTRATION, IMAGES);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            var prevPage = ((HttpServletRequest) servletRequest).getHeader("referer"); //С какой страницы пришел юзер
            ((HttpServletResponse) servletResponse).sendRedirect(prevPage != null ? prevPage : LOGIN);//Перенавравляет на предыдушию страницу или на Login
        }
    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        var user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return  user != null;
    }

    private boolean isPublicPath(String uri) {
        return PUBLIC_PATH.stream().anyMatch(uri::startsWith);
    }
}
