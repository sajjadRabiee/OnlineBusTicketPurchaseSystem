package Controller.Servlet.CityServlet;

import Controller.WrapFarsi;
import Service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-city")
public class AddCityServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WrapFarsi wrapFarsi = new WrapFarsi();
        String name = wrapFarsi.getFarsiString(req, "name");
        CityService cityService = new CityService();
        if(cityService.addCity(name)){
            resp.sendRedirect("/dashboard/admin/add-cities.html?true");
        }else{
            resp.sendRedirect("/dashboard/admin/add-cities.html?false");
        }
    }
}
