package Repository.DAOEntities;

import Service.Entities.User;

public class UserDAO extends BaseEntityDAO<User,Long> {
    @Override
    public void setEntityClass() {
        super.entityClass = User.class;
    }

    @Override
    public void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
