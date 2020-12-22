package Service;

import Repository.DAOEntities.TravelDAO;
import Service.Entities.Bus;
import Service.Entities.Travel;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TravelService implements BaseEntityService<Travel> {

    TravelDAO travelDAO = new TravelDAO();

    public TravelService(){
        travelDAO.setEntityClass();
    }

    @Override
    public Optional<Travel> findById(long id) {
        Optional<Travel> byID = travelDAO.findByID(id);
        return byID;
    }

    @Override
    public Optional<Travel> findByName(String name , String column) {
        travelDAO.setColumnName(column);
        Optional<Travel> byName = travelDAO.findByName(name);
        return byName;
    }

    @Override
    public List<Travel> findAll() {
        List<Travel> all = travelDAO.findAll();
        return all;
    }

    @Override
    public boolean add(Travel travel) {
        return travelDAO.add(travel);
    }

    @Override
    public boolean delete(Travel travel) {
        return travelDAO.delete(travel);
    }

    @Override
    public boolean update(Travel travel) {
        return travelDAO.update(travel);
    }

    public boolean addTravel(String beginning , String destination , String[] busesName, Date date, LocalTime time){
        Travel travel = new Travel();
        travel.setBeginning(beginning);
        travel.setDestination(destination);
        travel.setTravelNumber(findAll().size() + 2000);
        ArrayList<Bus> busesList = new ArrayList<>();
        BusService busService = new BusService();
        for(String bName : busesName){
            Bus bus = busService.findById(Long.parseLong(bName)).get();
            busesList.add(bus);
        }
        travel.setBuses(busesList);
        travel.setDateOfMovement(date);
        travel.setTimeOfMovement(time);
        return add(travel);
    }

    public List<Travel> findTravels(String beginning , String destination,Date date){
        List<Travel> travelByProperty = travelDAO.findTravelByProperty(beginning, destination, date);
        return travelByProperty;
    }
}
