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
public class HController {

    @PostMapping
    public void getCustomer(CustomerDTO customerDTO){
        System.out.println(customerDTO);
    }

}
