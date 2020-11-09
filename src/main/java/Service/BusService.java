package Service;

import Repository.DAOEntities.BusDAO;
import Service.Entities.Bus;

import java.util.List;
import java.util.Optional;

public class BusService implements BaseEntityService<Bus> {

    BusDAO busDAO = new BusDAO();

    public BusService(){
        busDAO.setEntityClass();
    }

    @Override
    public Optional<Bus> findById(long id) {
        Optional<Bus> byID = busDAO.findByID(id);
        return byID;
    }

    @Override
    public Optional<Bus> findByName(String name , String column) {
        busDAO.setColumnName(column);
        Optional<Bus> byName = busDAO.findByName(name);
        return byName;

    }

    @Override
    public List<Bus> findAll() {
        List<Bus> all = busDAO.findAll();
        return all;
    }

    @Override
    public boolean add(Bus bus) {
        return busDAO.add(bus);
    }

    @Override
    public boolean delete(Bus bus) {
        return busDAO.delete(bus);
    }

    @Override
    public boolean update(Bus bus) {
        return busDAO.update(bus);
    }
}
