package lk.ijse.spring.controller;

import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseUtil getCustomers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", service.getAllCustomer());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {
        System.out.println(customerDTO);

        service.saveCustomer(customerDTO);
        return new ResponseUtil("OK", "Successfully Added..!", "");

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        service.updateCustomer(customerDTO);
        return new ResponseUtil("200", "Successfully Updated..!", "");

    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestParam String cusId) {

        service.deleteCustomer(cusId);
        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

}
