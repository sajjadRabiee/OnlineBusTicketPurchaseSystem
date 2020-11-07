package Service;

import Service.Entities.Bus;

import java.util.List;
import java.util.Optional;

public class BusService implements BaseEntityService<Bus> {
    @Override
    public Optional<Bus> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<Bus> findByName() {
        return Optional.empty();
    }

    @Override
    public List<Bus> findAll() {
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
