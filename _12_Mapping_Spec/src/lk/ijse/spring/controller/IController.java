package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class IController {

    @PutMapping
    public void getCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
    }

//    @RequestBody is a required annotation that use to represent json value

}
