package tongatar111.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.entity.Order;
import tongatar111.shop.entity.User;
import tongatar111.shop.repository.CommentRepository;
import tongatar111.shop.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalCabinetService {

    private final OrderRepository orderRepository;

    private final CommentRepository commentRepository;

    private final UserService userService;


    public List<Order> orderList (){
        List<Order>orderList  = orderRepository.findAllByUserId(userService.getCurrentUser().getId());
        return orderList;
    }

    public List<Comment>commentList(){
        List<Comment>commentList = commentRepository.findAllByUserId(userService.getCurrentUser().getId());
        return commentList;

    }


}
