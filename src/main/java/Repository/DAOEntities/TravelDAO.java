package Repository.DAOEntities;

import Service.Entities.Travel;

public class TravelDAO extends BaseEntityDAO<Travel,Long> {
    @Override
    protected void setEntityClass() {
        super.entityClass = Travel.class;
    }

    @Override
    protected void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
