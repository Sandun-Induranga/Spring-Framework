package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/two")
public class TwoController {

    @GetMapping
    public String testOne1() {
        return "Get Method Invoked 1";
    }

    @GetMapping(path = "/a")
    public String testOne2() {
        return "Get Method Invoked 2";
    }

    @GetMapping(path = "/b")
    public String testOne3() {
        return "Get Method Invoked 3";
    }

}
