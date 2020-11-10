package Controller.Servlet;

import Service.Entities.Gender;
import Service.Entities.Role;
import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        Gender genderOfUser = null;
        if(gender.equals("male")){
            genderOfUser = Gender.male;
        }else if(gender.equals("female")){
            genderOfUser = Gender.female;
        }else if(gender.equals("other")){
            genderOfUser = Gender.other;
        }
        UserService userService = new UserService();
        userService.registerUser(name,username,password,genderOfUser, Role.User);
        resp.sendRedirect("login.html");
    }
}
