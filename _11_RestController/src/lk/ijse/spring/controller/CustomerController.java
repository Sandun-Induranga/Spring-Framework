package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public String testOne() {
        return "Hello There, How are You?";
    }

    // Can return any type from rest controllers
    // But Browser can read only json and string types

    @GetMapping
    public String testTwo(){
        return "Test Two";
    }

}
