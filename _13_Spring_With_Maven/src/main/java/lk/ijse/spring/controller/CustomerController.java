package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ResponseMessage;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.helpers.AttributeListImpl;

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
    public ResponseMessage getCustomers() {

        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));
        dtos.add(new CustomerDTO("C001","Dasun","Galle",1000));

        return new ResponseMessage("200", "Successfully Loaded..!", dtos);

    }

    @PostMapping
    public ResponseMessage saveCustomer(@ModelAttribute CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseMessage("200","Successfully Added..!", dtos);
    }

    @PutMapping
    public ResponseMessage updateCustomer(@RequestBody CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseMessage("200","Successfully Updated..!", dtos);
    }

    @DeleteMapping
    public ResponseMessage deleteCustomer(@RequestBody CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseMessage("200","Successfully Deleted..!", dtos);
    }

}
