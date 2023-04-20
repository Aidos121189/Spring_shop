package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.service.PersonalCabinetService;
import tongatar111.shop.service.UserService;

@RequestMapping(path = "/personal")
@RequiredArgsConstructor
@Controller
public class PersonalCabinetController {

    private final PersonalCabinetService personalCabinetService;
    private final UserService userService;



    @GetMapping(path = "/personal_cabinet")
    public ModelAndView cabinetPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cabinet/personal_cabinet");
        modelAndView.addObject("user", userService.getCurrentUser());
        modelAndView.addObject("order", personalCabinetService.orderList());
        modelAndView.addObject("comment", personalCabinetService.commentList());
        return modelAndView;

    }

}
