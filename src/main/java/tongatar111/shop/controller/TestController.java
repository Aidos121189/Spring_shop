package tongatar111.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping(path = "/first_resource", produces = "text/plain")
    public String firstResource () {
        return "<h2>Message from TestController.firstResource<h2>";

    }

    @GetMapping(path = "/second_resource", produces = "text/plain")
    public String secondResources(
            @RequestParam(name = "name", required = false) String zzz,
            @RequestParam(required = false) Integer age

    ) {
        return "TestController.secondResources -> {name: %s, age: %d}".formatted(zzz, age);


    }

    @GetMapping(path = "/third_resource", produces = "application/json")
    public List<String> thirdResource(@RequestParam(required = false) String prefix) {

        String[] names = new String[] {
          "Alex", "Mick", "Anubis", "Leon", "Anya", "Mark", "Maison"
        };

        List<String> filtered = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (names[i].startsWith(prefix)) {
                filtered.add(names[i]);
            }
        }

        return filtered;

    }
}


