package Service;

import Repository.DAOEntities.TicketDAO;
import Service.Entities.Ticket;

import java.util.List;
import java.util.Optional;

public class TicketService implements BaseEntityService<Ticket> {

    TicketDAO ticketDAO = new TicketDAO();

    public TicketService(){
        ticketDAO.setEntityClass();
    }

    @Override
    public Optional<Ticket> findById(long id) {
        Optional<Ticket> byID = ticketDAO.findByID(id);
        return byID;
    }

    @Override
    public Optional<Ticket> findByName(String name , String column) {
        ticketDAO.setColumnName(column);
        Optional<Ticket> byName = ticketDAO.findByName(name);
        return byName;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> all = ticketDAO.findAll();
        return all;
    }

    @Override
    public boolean add(Ticket ticket) {
        return ticketDAO.add(ticket);
    }

    @Override
    public boolean delete(Ticket ticket) {
        return ticketDAO.delete(ticket);
    }

    @Override
    public boolean update(Ticket ticket) {
        return ticketDAO.update(ticket);
    }
}
