package Service;

import Repository.DAOEntities.UserDAO;
import Service.Entities.User;

import java.util.List;
import java.util.Optional;

public class UserService implements BaseEntityService<User> {

    UserDAO userDAO = new UserDAO();

    public UserService(){
        userDAO.setEntityClass();
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> byID = userDAO.findByID(id);
        return byID;
    }

    @Override
    public Optional<User> findByName(String name , String column) {
        userDAO.setColumnName(column);
        Optional<User> byName = userDAO.findByName(name);
        return byName;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userDAO.findAll();
        return all;
    }

    @Override
    public boolean add(User user) {
        return userDAO.add(user);
    }

    @Override
    public boolean delete(User user) {
        return userDAO.delete(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }
}
