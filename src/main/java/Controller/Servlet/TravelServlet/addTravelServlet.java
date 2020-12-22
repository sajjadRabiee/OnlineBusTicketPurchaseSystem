package Controller.Servlet.TravelServlet;

import Controller.WrapFarsi;
import Service.BusService;
import Service.Entities.Bus;
import Service.TravelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@WebServlet("/add-travel")
public class addTravelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WrapFarsi wrapFarsi = new WrapFarsi();
        String beginning = req.getParameter("beginning");
        String destination = req.getParameter("destination");
        Date dateOfMovement = null;
        LocalTime timeOfMovement = null;
        try {
            dateOfMovement = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateOfMovement"));
        } catch (ParseException e) {
            System.out.println(req.getParameter("dateOfMovement"));
            e.printStackTrace();
        }
        timeOfMovement = LocalTime.parse(req.getParameter("timeOfMovement"));
        String[] busesName = req.getParameterValues("buses");
        TravelService travelService = new TravelService();
        if(travelService.addTravel(beginning,destination,busesName,dateOfMovement,timeOfMovement)){
            resp.sendRedirect("/dashboard/admin/add-travel.jsp?true");
        }else{
            resp.sendRedirect("/dashboard/admin/add-travel.jsp?false");
        }
    }
}
