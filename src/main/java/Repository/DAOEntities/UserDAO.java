package Repository.DAOEntities;

import Service.Entities.User;

public class UserDAO extends BaseEntityDAO<User,Long> {
    @Override
    protected void setEntityClass() {
        super.entityClass = User.class;
    }

    @Override
    protected void setColumnName(String columnName) {
        super.columnName = columnName;
    }
}
