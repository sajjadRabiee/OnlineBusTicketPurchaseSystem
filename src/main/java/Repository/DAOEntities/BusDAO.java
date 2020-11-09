package Repository.DAOEntities;

import Service.Entities.Bus;

public class BusDAO extends BaseEntityDAO<Bus,Long> {
    @Override
    public void setEntityClass() {
        super.entityClass = Bus.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
