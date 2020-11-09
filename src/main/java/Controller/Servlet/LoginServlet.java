package Controller.Servlet;

import Service.Entities.User;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();
        Optional<User> oUser = userService.loginUser(username, password);
        if(oUser.isPresent()){
            User user = oUser.get();
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("online_user",user);
            resp.sendRedirect("/dashboard");
        }else{
            resp.sendRedirect("login.html");
        }
    }
}
