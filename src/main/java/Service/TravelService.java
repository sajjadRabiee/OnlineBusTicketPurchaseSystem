package Service;

import Service.Entities.Travel;

import java.util.List;
import java.util.Optional;

public class TravelService implements BaseEntityService<Travel> {
    @Override
    public Optional<Travel> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<Travel> findByName() {
        return Optional.empty();
    }

    @Override
    public List<Travel> findAll() {
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
