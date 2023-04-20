package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final UserService userService;



    public void addNewComment(Comment comment){
        commentRepository.save(comment);

    }

    public List<Comment> comments() {
        List<Comment> comments = commentRepository.findAllByModeration(true);
        return comments;
    }



    public List<Comment> commentList (Long productId){
        List<Comment> commentList = commentRepository.findAllByProductIdAndModeration(productId, true);

        return commentList;
    }



}


