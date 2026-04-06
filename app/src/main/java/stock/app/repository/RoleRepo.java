package stock.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stock.app.enums.UserRoles;
import stock.app.models.Role;

import java.util.Optional;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

    Optional<Role> findByRoleName(UserRoles role);
}
