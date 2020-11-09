package Service;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService<Entity> {
    Optional<Entity> findById(long id);
    Optional<Entity> findByName(String name , String column);
    List<Entity> findAll();
    boolean add(Entity entity);
    boolean delete(Entity entity);
    boolean update(Entity entity);
}
