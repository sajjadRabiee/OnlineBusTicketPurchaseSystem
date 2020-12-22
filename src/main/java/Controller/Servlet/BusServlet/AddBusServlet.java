package Controller.Servlet.BusServlet;

import Service.BusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-bus")
public class AddBusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int busNumber = Integer.parseInt(req.getParameter("bus-number"));
        int valency = Integer.parseInt(req.getParameter("valency"));
        BusService busService = new BusService();
        if(busService.addBus(busNumber,valency)){
            resp.sendRedirect("/dashboard/admin/add-bus.html?true");
        }else{
            resp.sendRedirect("/dashboard/admin/add-bus.html?false");
        }
    }
}
