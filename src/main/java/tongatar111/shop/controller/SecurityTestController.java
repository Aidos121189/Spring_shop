package tongatar111.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/security_test")
public class SecurityTestController {

    @GetMapping(path = "/first_resource")
    public String firstResource() {
        return "SecurityTestController.firstResource";

    }

    @GetMapping(path = "/second_resource")
    public String secondResource() {


        return "SecurityTestController.secondResource";

    }

}




