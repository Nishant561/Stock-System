package stock.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stock.app.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
}
