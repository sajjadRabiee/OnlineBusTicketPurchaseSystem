package Repository.DAOEntities;

import Service.Entities.City;

public class CityDAO extends BaseEntityDAO<City,Long>{
    @Override
    public void setEntityClass() {
        super.entityClass = City.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
