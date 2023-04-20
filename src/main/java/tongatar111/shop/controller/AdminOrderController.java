package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.enumeration.StatusOrder;
import tongatar111.shop.service.OrderService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminOrderController {


    private final OrderService orderService;

    @GetMapping
    public ModelAndView changeRole(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/admin_list");
        modelAndView.addObject("statuses", StatusOrder.values());
        modelAndView.addObject("orders", orderService.orderList());
        return modelAndView;
    }

    @GetMapping(path = "/change")
    public ModelAndView changeStatus(@RequestParam StatusOrder status, Long order){
        orderService.changeStatus(status, order);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;

    }
}
