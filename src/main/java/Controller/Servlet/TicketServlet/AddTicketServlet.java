package Controller.Servlet.TicketServlet;

import Controller.WrapFarsi;
import Service.Entities.Gender;
import Service.Entities.User;
import Service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/add-ticket")
public class AddTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WrapFarsi wrapFarsi = new WrapFarsi();
        String name = wrapFarsi.getFarsiString(req,"name");
        String gender = req.getParameter("gender");
        Gender genderOfUser = null;
        if(gender.equals("male")){
            genderOfUser = Gender.male;
        }else if(gender.equals("female")){
            genderOfUser = Gender.female;
        }else if(gender.equals("other")){
            genderOfUser = Gender.other;
        }
        HttpSession session = req.getSession();
        Long ticketId = Long.parseLong((String) session.getAttribute("ticket-id"));
        User online_user = (User) session.getAttribute("online_user");
        TicketService ticketService = new TicketService();
        boolean bool = ticketService.addTicket(online_user, ticketId, name, genderOfUser);
        if(bool){
            resp.sendRedirect("/dashboard/user/add-ticket.jsp?true");
        }else{
            resp.sendRedirect("/dashboard/user/add-ticket.jsp?false");
        }
    }
}
