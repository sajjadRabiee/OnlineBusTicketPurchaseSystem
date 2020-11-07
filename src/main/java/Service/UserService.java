package Service;

import Service.Entities.User;

import java.util.List;
import java.util.Optional;

public class UserService implements BaseEntityService<User> {
    @Override
    public Optional<User> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByName() {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
