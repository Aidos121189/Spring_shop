package tongatar111.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.pojo.Product;

import java.util.List;

@Controller
@RequestMapping(path = "/test2")
public class TestController2 {

   @GetMapping(path = "/first_resource")
    public ModelAndView firstResource() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("first_resource");
        modelAndView.addObject("message", "Message from TestController2"); // - ключ - значение (message, значение - Message from TestController2).
        modelAndView.addObject("tasks", List.of(

                "Learn Spring",
                "Hello Word!",
                "ABC"

        ));
        return modelAndView;
    }


    private List<Product> products = List.of(
            new Product("Теплые вещи", "Ушанка Мазай", 12000),
            new Product("Кухонная техника", "Электрическая плита Zanussi", 99999),
            new Product("Спорт", "Кроссовки Adidas", 80000),
            new Product("Досуг", "Книга Золотая Орда", 6000)

    );


    @GetMapping(path = "/second_resource")
    public ModelAndView productResource() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("second_resource");
        modelAndView.addObject("product", products);
        return modelAndView;

    }
}

