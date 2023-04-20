package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.Value;

public interface ValueRepository extends JpaRepository<Value, Long> {
}
