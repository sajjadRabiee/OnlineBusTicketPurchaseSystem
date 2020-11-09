package Controller.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/dashboard/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;
        HttpSession session = httpReq.getSession(false);
        if(session==null || session.getAttribute("online_user")==null){
            httpResp.sendRedirect(httpReq.getContextPath() + "/login.html");
        }else{
            filterChain.doFilter(httpReq,httpResp);
        }

    }

    @Override
    public void destroy() {

    }
}
