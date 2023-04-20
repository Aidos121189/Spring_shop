package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByLogin(String login);

}
