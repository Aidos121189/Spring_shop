package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Order;
import tongatar111.shop.entity.enumeration.StatusOrder;
import tongatar111.shop.repository.OrderRepository;
import tongatar111.shop.service.OrderService;
import tongatar111.shop.service.UserService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    @PostMapping(path = "/order_resource")
    public ModelAndView orderPage(
            @RequestParam(required = true) String street ,
            @RequestParam(required = true) String building,
            @RequestParam(required = true) String floor,
            @RequestParam(required = true) String flat
    ) {


        Order order = new Order();
        order.setUser(userService.getCurrentUser());
        order.setStatus(StatusOrder.FORMATED);
        order.setStreet(street);
        order.setBuilding(building);
        order.setFloor(floor);
        order.setFlat(flat);
        order.setDate(LocalDateTime.now());

        orderService.addOrder(order);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cart");
        return modelAndView;

    }

}
