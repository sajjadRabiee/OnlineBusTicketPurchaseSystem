package Service;

import Repository.DAOEntities.TicketDAO;
import Service.Entities.Gender;
import Service.Entities.Ticket;
import Service.Entities.Travel;
import Service.Entities.User;

import java.util.Date;
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

    public boolean addTicket(User user, long travelId, String name , Gender gender){
        Ticket ticket = new Ticket();
        ticket.setName(name);
        ticket.setGender(gender);
        ticket.setTicketIssuanceTime(new Date());
        ticket.setTicketNumber(2500 + user.getId() + findAll().size());
        TravelService travelService = new TravelService();
        Optional<Travel> travel = travelService.findById(travelId);
        ticket.setTravel(travel.get());
        ticket.setUser(user);
        boolean add = add(ticket);
        UserService userService = new UserService();
        userService.update(user);
        return add;
    }

    public List<Ticket> findTicketsOfUser(User user){
        return ticketDAO.findTicketesOfUser(user);
    }
}
