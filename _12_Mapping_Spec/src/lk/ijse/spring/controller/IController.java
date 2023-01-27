package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class IController {

    @PutMapping
    public ArrayList<CustomerDTO> getCustomer(@RequestBody CustomerDTO customerDTO){
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);
        dtos.add(customerDTO);
        dtos.add(customerDTO);
        dtos.add(customerDTO);
        return dtos;
    }

//    @RequestBody is a required annotation that use to represent json value

}
