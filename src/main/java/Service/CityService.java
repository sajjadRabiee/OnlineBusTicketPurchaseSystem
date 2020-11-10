package Service;

import Repository.DAOEntities.CityDAO;
import Service.Entities.City;

import java.util.List;
import java.util.Optional;

public class CityService implements BaseEntityService<City>{
    CityDAO cityDAO = new CityDAO();

    public CityService(){
        cityDAO.setEntityClass();
    }

    @Override
    public Optional<City> findById(long id) {
        Optional<City> byID = cityDAO.findByID(id);
        return byID;
    }

    @Override
    public Optional<City> findByName(String name, String column) {
        cityDAO.setColumnName(column);
        Optional<City> byName = cityDAO.findByName(name);
        return byName;
    }

    @Override
    public List<City> findAll() {
        List<City> all = cityDAO.findAll();
        return all;
    }

    @Override
    public boolean add(City city) {
        return cityDAO.add(city);
    }

    @Override
    public boolean delete(City city) {
        return cityDAO.delete(city);
    }

    @Override
    public boolean update(City city) {
        return cityDAO.update(city);
    }

    public boolean addCity(String name){
        City city = new City();
        city.setName(name);
        return add(city);
    }
}
