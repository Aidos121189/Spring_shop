package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/login")
public class LoginController {

    private final UserService userService;

//    public ModelAndView loginPage(){
//        User currentUser = userService.getCurrentUser();
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("auth/login_page");
//        return modelAndView;
//    }
}
