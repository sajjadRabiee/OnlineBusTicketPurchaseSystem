package Repository.DAOEntities;

import Service.Entities.Ticket;

public class TicketDAO extends BaseEntityDAO<Ticket,Long>{
    @Override
    public void setEntityClass() {
        super.entityClass = Ticket.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
