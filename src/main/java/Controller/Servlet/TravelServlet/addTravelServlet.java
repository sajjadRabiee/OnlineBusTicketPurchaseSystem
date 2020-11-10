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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@WebServlet("/add-travel")
public class addTravelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String beginning = WrapFarsi.getFarsiString(req, "beginning");
        String destination = WrapFarsi.getFarsiString(req, "destination");
        Date timeOfMovement = null;
        try {
            timeOfMovement = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("timeOfMovement"));
        } catch (ParseException e) {
            System.out.println(req.getParameter("timeOfMovement"));
            e.printStackTrace();
        }

        String[] busesName = req.getParameterValues("buses");
        TravelService travelService = new TravelService();
        if(travelService.addTravel(beginning,destination,busesName,timeOfMovement)){
            resp.sendRedirect("/dashboard/admin/add-travel.jsp?true");
        }else{
            resp.sendRedirect("/dashboard/admin/add-travel.jsp?false");
        }
    }
}
