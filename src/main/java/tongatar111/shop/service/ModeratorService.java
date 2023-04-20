package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.entity.OrderProducts;
import tongatar111.shop.entity.Product;
import tongatar111.shop.repository.CommentRepository;
import tongatar111.shop.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeratorService {

    private final CommentRepository commentRepository;



    public List <Comment> commentList (){
        List<Comment> commentList = commentRepository.findAllByModeration(false);
        return commentList;
    }

    public void saveModerationNewComment(Comment comment){
        commentRepository.save(comment);


    }

}
