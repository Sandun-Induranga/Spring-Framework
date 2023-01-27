package lk.ijse.spring.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class HController {

    @PostMapping
    public void getCustomer(@RequestParam String cusId, @RequestParam String cusName, @RequestParam String cusAddress, @RequestParam double cusSalary){
        System.out.println(cusId);
        System.out.println(cusName);
        System.out.println(cusAddress);
        System.out.println(cusSalary);
    }

}
