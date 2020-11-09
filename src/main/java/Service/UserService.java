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

    public Optional<User> loginUser(String username , String password){
        User user;
        Optional<User> nullUser = Optional.ofNullable(null);
        Optional<User> userByName = findByName(username, "name");
        if(userByName.isPresent()){
            user = userByName.get();
            if(user.getPassword().equals(password)){
                return userByName;
            }else{
                return nullUser;
            }
        }else{
            return nullUser;
        }
    }
}
