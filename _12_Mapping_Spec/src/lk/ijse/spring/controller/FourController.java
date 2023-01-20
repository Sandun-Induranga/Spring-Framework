package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/four")
public class FourController {


    // Character Mapping

    // ?    -> Any Character can assign this in url

    @GetMapping(path = "/C?DEF")
    public String testOne() {
        return "Method Invoked";
    }

    @GetMapping(path = "/C??DEF")
    public String testTwo() {
        return "Method Invoked";
    }

}
