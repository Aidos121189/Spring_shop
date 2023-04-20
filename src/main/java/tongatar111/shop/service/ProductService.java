package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tongatar111.shop.entity.*;
import tongatar111.shop.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final OptionRepository optionRepository;
    private final ValueRepository valueRepository;

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    private final UserService userService;



    public void addDescriptionProduct(
            long categoryId,
            String name,
            int price,
            List<Long>option,
            List<String>value)
    {

        Category category = categoryRepository.findById(categoryId).orElseThrow();
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        productRepository.save(product);


        for (int i = 0; i < option.size(); i++) {
            Long optionId = option.get(i);
            String valueOption = value.get(i);
            Option option1 = optionRepository.findById(optionId).orElseThrow();

            Value value1 = new Value();
            value1.setProduct(product);
            value1.setOption(option1);
            value1.setValue(valueOption);

            valueRepository.save(value1);
        }
    }


    public List<Category> categories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;

    }



    public List<Product> productList() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }



    public Product product (Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        return product;
    }



    public double statusRating (Long productId) {
        double averageRating = 0;
        if (commentService.commentList(productId).size() != 0) {
            for (Comment comment : commentService.commentList(productId)) {
                averageRating += comment.getScore() / commentService.commentList(productId).size();
            }
        }

        return averageRating;
    }


    public boolean prohibitingRepeatedComments(long productId) {
        boolean result;
        if (userService.getCurrentUser() != null) {
            Comment comment = commentRepository.findByProductIdAndUserId(productId, userService.getCurrentUser().getId());
            result = true;
            if (comment != null) {
                result = false;
            } else {
                result = true;
            }
        } else {
            result = false;
        }

        return result;


    }


}
