package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping
    public ResponseUtil getCustomers() {

        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));

        return new ResponseUtil("200", "Successfully Loaded..!", dtos);

    }

    // @ModelAttribute not compulsory
    @PostMapping
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseUtil("200","Successfully Added..!", dtos);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseUtil("200","Successfully Updated..!", dtos);
    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestParam String id){

        System.out.println(id);

        return new ResponseUtil("200","Successfully Deleted..!", "");
    }

}
