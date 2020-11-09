package Service;

import Repository.DAOEntities.TravelDAO;
import Service.Entities.Travel;

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
}
