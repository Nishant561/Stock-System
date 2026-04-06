package stock.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stock.app.models.User;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
