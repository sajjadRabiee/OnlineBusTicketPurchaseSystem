package Controller.Servlet.UserServlet;

import Service.Entities.Role;
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
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("online_user");
        if(user.getRole().equals(Role.User)){
            resp.sendRedirect("/dashboard/user/user-page.html");
        }else{
            resp.sendRedirect("/dashboard/admin/admin-page.html");
        }
    }
}
