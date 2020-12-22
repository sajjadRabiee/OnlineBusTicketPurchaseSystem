package Controller.Filter;

import Service.Entities.User;
import Service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        Optional<User> oUser = userService.loginUser(username, password);
        if(oUser.isPresent()){
            User user = oUser.get();
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("online_user",user);
            filterChain.doFilter(req,resp);
        }else{
            resp.sendRedirect("/main-pages/login.html?false");
        }
    }

    @Override
    public void destroy() {

    }
}
