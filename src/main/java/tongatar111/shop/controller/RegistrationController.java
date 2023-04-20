package tongatar111.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tongatar111.shop.entity.Product;
import tongatar111.shop.entity.User;
import tongatar111.shop.entity.enumeration.UserRole;
import tongatar111.shop.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/user_test")
public class RegistrationController {

    private final UserRepository userRepository;

    @GetMapping(path = "/user_resource")
    public ModelAndView UserResource() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/registration_user_list");
        return modelAndView;
    }

    @PostMapping(path = "/user_resource")
    public ModelAndView UserResourcePost(

            @RequestParam(required = true) String name,
            @RequestParam(required = true) String surname,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String number,
            @RequestParam(required = true) String login,
            @RequestParam(required = true) String password


    ) {

        User user = new User();

        user.setRole(UserRole.USER);
        user.setDate(LocalDateTime.now());
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setNumber(number);
        user.setLogin(login);
        user.setPassword(password);



        userRepository.save(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/successful_registration_page");
        return modelAndView;

    }

}

