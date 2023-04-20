package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Order;
import tongatar111.shop.entity.OrderProducts;
import tongatar111.shop.entity.enumeration.StatusOrder;
import tongatar111.shop.repository.Cart_itemReposytory;
import tongatar111.shop.repository.OrderProductsRepository;
import tongatar111.shop.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;
    private final Cart_itemReposytory cart_itemReposytory;
    private final UserService userService;

    @Transactional                            // - если метод просит транзакцию, то надо использовать эту аннотацию;
    public void addOrder(Order order) {
        orderRepository.save(order);

        List<Cart_item> cartItemList = cart_itemReposytory.findAllByUserId(userService.getCurrentUser().getId());
        for (Cart_item cart : cartItemList) {
            OrderProducts orderProducts = new OrderProducts();
            orderProducts.setOrder(order);
            orderProducts.setProduct(cart.getProduct());
            orderProducts.setAmount(cart.getQuantity());
            orderProductsRepository.save(orderProducts);
        }

        cart_itemReposytory.deleteByUser(userService.getCurrentUser());

    }


    public List<Order> orderList() {
        List<Order> orderList = orderRepository.findByUserId(userService.getCurrentUser().getId());
        return orderList;

    }

    public void changeStatus (StatusOrder statusOrder, Long OrderId){
        Order order = orderRepository.findById(OrderId).orElseThrow();
        order.setStatus(statusOrder);
        orderRepository.save(order);

    }


}
