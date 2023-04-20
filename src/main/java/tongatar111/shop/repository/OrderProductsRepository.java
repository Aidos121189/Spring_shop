package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.OrderProducts;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long> {

}
