package Repository.DAOEntities;

import Service.Entities.Travel;

public class TravelDAO extends BaseEntityDAO<Travel,Long> {
    @Override
    public void setEntityClass() {
        super.entityClass = Travel.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
