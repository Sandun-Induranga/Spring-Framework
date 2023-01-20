package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/five")
public class FveController {




    //    Wild Card Mapping


    @GetMapping(path = "/path/*/A/B")
    public String testOne(){
        return "Method Invoked";
    }

    @GetMapping(path = "/path/*/A/B")
    public String testTwo(){
        return "Method Invoked";
    }

}
