package Controller.Servlet.TicketServlet;

import Service.Entities.Ticket;
import Service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-ticket")
public class deleteTicketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long ticketId = Long.parseLong(req.getParameter("ticket-id"));
        TicketService ticketService = new TicketService();
        Ticket ticket = ticketService.findById(ticketId).get();
        if(ticketService.delete(ticket)){
            resp.sendRedirect("/dashboard/user/user-tickets.jsp?true");
        }else{
            resp.sendRedirect("/dashboard/user/user-tickets.jsp?false");
        }
    }
}
