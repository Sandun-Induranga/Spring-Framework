package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/six")
public class SixController {


    @GetMapping(params = {"id", "name"})
    public String testOne(){
        return "Method Invoked";
    }

    @GetMapping(params = {"address", "salary"})
    public String testTwo(){
        return "Method Invoked";
    }

}
