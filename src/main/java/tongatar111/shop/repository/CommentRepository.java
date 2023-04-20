package tongatar111.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tongatar111.shop.entity.Cart_item;
import tongatar111.shop.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByProductIdAndModeration(long productId, boolean moderation);

    Comment findById(long commentId);


    List<Comment> findAllByModeration(boolean moderation);

    List<Comment> findAllByUserId(long userId);

    Comment findByProductIdAndUserId(long productId, long userId);



}
