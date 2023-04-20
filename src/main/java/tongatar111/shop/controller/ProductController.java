package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Category;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.entity.Product;
import tongatar111.shop.repository.*;
import tongatar111.shop.service.CommentService;
import tongatar111.shop.service.ProductService;
import tongatar111.shop.service.UserService;

import java.util.List;

@RequestMapping(path = "/product_add")
@RequiredArgsConstructor
@Controller
public class ProductController {

    private final CategoryRepository categoryRepository;

    private final CommentService commentService;

    private final ProductService productService;


    @GetMapping(path = "/product_description")
    public ModelAndView UserResource(@RequestParam long categoryId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/product_add_description");
        modelAndView.addObject("category", categoryRepository.findById(categoryId).orElseThrow());
        return modelAndView;
    }

    @PostMapping(path = "/product_description")
    public ModelAndView UserProductPost(
            @RequestParam(required = true) Long categoryId,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer price,
            @RequestParam(required = true) List<Long> option,
            @RequestParam List<String> value

    ) {


        productService.addDescriptionProduct(categoryId, name, price, option, value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/new_product");
        return modelAndView;

    }


    // - выбор существующих категорий, начинаем с этого, потом переходим на наименование и цену.
    @GetMapping(path = "/select_category")
    public ModelAndView ProductOption() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/select_category");
        modelAndView.addObject("categories", productService.categories());
        return modelAndView;

    }

    @GetMapping(path = "/product_list")
    public ModelAndView ProductList() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/product_list_list");
        modelAndView.addObject("products", productService.productList());
        return modelAndView;


    }

    @GetMapping(path = "/product_page")
    public ModelAndView SeparateProduct(
            @RequestParam(required = true) Long productId
    ) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product/product_page");
        modelAndView.addObject("product", productService.product(productId));


        modelAndView.addObject("total", productService.statusRating(productId));
        modelAndView.addObject("moderators", commentService.commentList(productId));
        modelAndView.addObject("result", productService.prohibitingRepeatedComments(productId));
        return modelAndView;

    }

}












