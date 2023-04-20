package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(long Id);

    List<Order> findByUserId(long userId);

    List<Order> findAllByUserId(long userId);


}
