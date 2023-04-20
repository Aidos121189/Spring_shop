package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.repository.Cart_itemReposytory;
import tongatar111.shop.repository.OptionRepository;
import tongatar111.shop.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ProductRepository productRepository;
    private final Cart_itemReposytory cart_itemReposytory;
    private final UserService userService;

    public void addProductToCart(Long productId) {
        Cart_item cart_item = new Cart_item();
        cart_item.setUser(userService.getCurrentUser());
        cart_item.setProduct(productRepository.findById(productId).orElseThrow());
        cart_item.setQuantity(1);
        cart_itemReposytory.save(cart_item);
    }

    public List<Cart_item> cartItemList (){
        List<Cart_item> cartItemList = cart_itemReposytory.findAllByUserId(userService.getCurrentUser().getId());
        return cartItemList;
    }

    public void cartPlus (Long productId) {
        Cart_item cart_item = cart_itemReposytory.findByProductIdAndUserId(productId, userService.getCurrentUser().getId());
        cart_item.setUser(userService.getCurrentUser());
        cart_item.setProduct(productRepository.findById(productId).orElseThrow());
        cart_item.setQuantity(cart_item.getQuantity()+1);
        cart_itemReposytory.save(cart_item);


    }

    public void cartMinus (Long productId) {
        Cart_item cart_item = cart_itemReposytory.findByProductIdAndUserId(productId, userService.getCurrentUser().getId());
        cart_item.setUser(userService.getCurrentUser());
        cart_item.setProduct(productRepository.findById(productId).orElseThrow());
        cart_item.setQuantity(cart_item.getQuantity() - 1);
        if (cart_item.getQuantity() == 0) {
            cart_itemReposytory.delete(cart_item);
        } else {
            cart_itemReposytory.save(cart_item);
        }

    }

}


