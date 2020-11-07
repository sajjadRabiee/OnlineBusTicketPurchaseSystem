package Repository.DAOEntities;

import Service.Entities.Bus;

public class BusDAO extends BaseEntityDAO<Bus,Long> {
    @Override
    protected void setEntityClass() {
        super.entityClass = Bus.class;
    }

    @Override
    protected void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
