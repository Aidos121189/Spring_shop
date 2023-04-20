package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Category;
import tongatar111.shop.entity.Product;
import tongatar111.shop.repository.CategoryRepository;
import tongatar111.shop.repository.ProductRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/repository_test")
public class RepositoryController {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;



    @GetMapping(path = "/first_resource")
    public ModelAndView FirstResource() {
        List<Product> products = productRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("repository/product_list");
        modelAndView.addObject("products", products);
        return modelAndView;

    }


    @GetMapping(path = "/second_resource")
    public ModelAndView secondResource() {



        //List<Product> products = productRepository.findAllByPriceAfter(170_000);
        //List<Product> products = productRepository.findAllByCategoryId(2);
        //List<Product> products = productRepository.findAllByCategoryName("Процессоры");
        List<Product> products = productRepository.findAllByNameContainingAndPriceBetween("nte", 50_000, 300_000);
        //List<Product> products1 = productRepository.findAllByNameAndPrice("%Ryzen%", 50_000, 210_000);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("repository/product_list");
        modelAndView.addObject("products", products);
        return modelAndView;

    }



    @GetMapping(path = "/third_resource")
    public ModelAndView thirdResource(
        @RequestParam(required = false) Long categoryId,
        @RequestParam(required = false) Integer minPrice,
        @RequestParam(required = false) Integer maxPrice

        ) {


        List<Category> categories = categoryRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("repository/product_list_practice");
        modelAndView.addObject("categories", categories);
        List<Product> products = productRepository.findAllByCategoryIdAndPriceBetween(categoryId, minPrice, maxPrice);
        modelAndView.addObject("products", products);
        return modelAndView;



    }

}
