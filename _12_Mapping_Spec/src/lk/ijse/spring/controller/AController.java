package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/one")
public class AController {

    @GetMapping
    public String testOne1() {
        return "Get Method Invoked";
    }

//    @GetMapping               // Error    // Ambiguous Method
//    public String testOne2() {
//        return "Get Method Invoked";
//    }

    @PostMapping
    public String testTwo() {
        return "Post Method Invoked";
    }

    @PutMapping
    public String testThree() {
        return "Put Method Invoked";
    }

    @DeleteMapping
    public String testFour() {
        return "Delete Method Invoked";
    }

    // Mapping Spec use to consult dispatcher servlet

}
