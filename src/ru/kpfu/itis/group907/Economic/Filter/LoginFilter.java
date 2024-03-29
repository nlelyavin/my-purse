package kpfu.itis.group907.Economic.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        if(req.getSession().getAttribute("name") == null && !uri.contains("Login.ftl") && !uri.contains("login") &&  !uri.contains("registration") && !uri.contains("Registration.ftl")){
            response.sendRedirect("/login");
        }
        else filterChain.doFilter(servletRequest,servletResponse);
    }


}
