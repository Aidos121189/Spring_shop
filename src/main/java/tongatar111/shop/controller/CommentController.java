package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.repository.CommentRepository;
import tongatar111.shop.repository.ProductRepository;
import tongatar111.shop.service.CommentService;
import tongatar111.shop.service.UserService;

import java.time.LocalDateTime;


@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/comment")
public class CommentController {



    private final CommentService commentService;

    private final UserService userService;

    private final ProductRepository productRepository;

    private final CommentRepository commentRepository;

    public ModelAndView commentPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product_page");

        return modelAndView;

    }


    @PostMapping (path = "/comment_resource")
    public ModelAndView addComment(
            @RequestParam(required = true) Long productId,
            @RequestParam(required = true) Integer score,
            @RequestParam(required = true) String comment

    ){

        Comment comment1 = new Comment();
        comment1.setUser(userService.getCurrentUser());
        comment1.setProduct(productRepository.findById(productId).orElseThrow());
        comment1.setModeration(false);
        comment1.setScore(score);
        comment1.setComment(comment);
        comment1.setDate(LocalDateTime.now());
        commentService.addNewComment(comment1);


        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/moderator_resource");
        //modelAndView.addObject("result", result);
        return modelAndView;


    }

}
