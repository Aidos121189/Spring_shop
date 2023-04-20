package tongatar111.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.service.CartService;
import tongatar111.shop.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @GetMapping
    public ModelAndView cartPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/cart/cart_item_list");
        modelAndView.addObject("cartItems", cartService.cartItemList());

        int sum = 0;
        for (Cart_item cart_item : cartService.cartItemList()) {
            sum += cart_item.getProduct().getPrice();

        }
        modelAndView.addObject("total", sum);


        return modelAndView;
        // - страница вывода содержимого страницы;
    }

    @GetMapping(path = "/add")                                               // - страница для добавления товара в корзину
    public ModelAndView addProductToCart(@RequestParam long productId){        // - передаем параметр long productId
        cartService.addProductToCart(productId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cart");
        return modelAndView;
        // - страница добавления товаров
    }

    @GetMapping(path = "/increase")
    public ModelAndView increaseProductCount(@RequestParam long productId){
        cartService.cartPlus(productId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cart");
        return modelAndView;
        // - страница увеличения товара на единицу в корзине;
    }


    @GetMapping(path = "/decrease")
    public ModelAndView decreaseProductCount(@RequestParam long productId){
        cartService.cartMinus(productId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cart");
        return modelAndView;
        // - страница уменьшения товара на единицу в корзине

    }

}


