package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Category;
import tongatar111.shop.entity.User;

import java.util.List;

public interface Cart_itemReposytory extends JpaRepository<Cart_item, Long> {

    List<Cart_item> findAllByUserId(long userId);

    Cart_item findByProductIdAndUserId(long productId, long userId);


    void deleteByUser(User user);
}
