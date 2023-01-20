package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/seven")
public class SevenController {

    /* There are two parts in a request
    *       1. Header
    *       2. Body
    * */

    @GetMapping()
    public String testOne() {
        return "Method Invoked 1";
    }

    @GetMapping(consumes = {"Application/json"})
    public String testTwo() {
        return "Method Invoked 2";
    }

}
