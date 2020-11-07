package Repository.DAOEntities;

import Service.Entities.Ticket;

public class TicketDAO extends BaseEntityDAO<Ticket,Long>{
    @Override
    protected void setEntityClass() {
        super.entityClass = Ticket.class;
    }

    @Override
    protected void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
