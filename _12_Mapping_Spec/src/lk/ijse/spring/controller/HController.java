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

//    @PostMapping
//    public void getCustomer(String cusId, String cusName, String cusAddress, String cusSalary){
//        System.out.println(cusId);
//        System.out.println(cusName);
//        System.out.println(cusAddress);
//        System.out.println(cusSalary);
//    }

    @PostMapping // For x-www form url encoded data
    public void getCustomer(@ModelAttribute CustomerDTO customerDTO){
        System.out.println(customerDTO);
    }

    // @RequestParam (Query String / x-www) Not Required
    // @ModelAttribute (Query String / x-www) Required

//    @GetMapping // For Query String
//    public void getCustomer(CustomerDTO customerDTO){
//        System.out.println(customerDTO);
//    }

}
