package Service;

import java.util.List;
import java.util.Optional;

public interface BaseEntityService<Entity> {
    Optional<Entity> findById();
    Optional<Entity> findByName();
    List<Entity> findAll();
    boolean add();
    boolean delete();
    boolean update();
}
