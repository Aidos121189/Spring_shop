package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Comment;
import tongatar111.shop.repository.CommentRepository;
import tongatar111.shop.service.ModeratorService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/moderation")
public class ModeratorController {

    private final CommentRepository commentRepository;
    private final ModeratorService moderatorService;


    @GetMapping(path = "/moderator_resource")
    public ModelAndView moderatorPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("moderator/moderation_list");
        modelAndView.addObject("moderation", moderatorService.commentList());
        return modelAndView;

    }


    @PostMapping(path = "/moderator_resource")
    public ModelAndView moderationComment(

            @RequestParam(required = true) Long commentId,
            @RequestParam(required = true) boolean moderation

    ){
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.setModeration(moderation);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/moderator_resource");
        moderatorService.saveModerationNewComment(comment);
        return modelAndView;


    }

}
