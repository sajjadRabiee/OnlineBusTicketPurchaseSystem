package Repository.DAOEntities;

import Service.Entities.City;

public class CityDAO extends BaseEntityDAO<City,Long>{
    @Override
    protected void setEntityClass() {
        super.entityClass = City.class;
    }

    @Override
    protected void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
