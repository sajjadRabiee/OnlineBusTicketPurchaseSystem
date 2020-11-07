package Service;

import Service.Entities.Ticket;

import java.util.List;
import java.util.Optional;

public class TicketService implements BaseEntityService<Ticket> {
    @Override
    public Optional<Ticket> findById() {
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> findByName() {
        return Optional.empty();
    }

    @Override
    public List<Ticket> findAll() {
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
