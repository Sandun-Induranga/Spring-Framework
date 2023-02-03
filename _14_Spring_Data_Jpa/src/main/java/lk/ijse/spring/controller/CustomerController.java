package lk.ijse.spring.controller;

import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerRepo repo;

    @GetMapping
    public ResponseUtil getCustomers() {

        List<Customer> customers = repo.findAll();
        return new ResponseUtil("OK", "Successfully Loaded..!", customers);

    }

    // @ModelAttribute not compulsory
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {

        if (repo.existsById(customerDTO.getCusId())) {
            throw new RuntimeException("Customer Already Exists..!");
        } else {
            repo.save(new Customer(customerDTO.getCusId(), customerDTO.getCusName(), customerDTO.getCusAddress(), customerDTO.getCusSalary()));
        }
        return new ResponseUtil("OK", "Successfully Added..!", "");

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        if (repo.existsById(customerDTO.getCusId())) {
            repo.save(new Customer(customerDTO.getCusId(), customerDTO.getCusName(), customerDTO.getCusAddress(), customerDTO.getCusSalary()));
        } else {
            throw new RuntimeException("Customer Not Exists..!");
        }
        return new ResponseUtil("200", "Successfully Updated..!", customerDTO);

    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestParam String cusId) {

        if (repo.existsById(cusId)) {
            repo.deleteById(cusId);
        } else {
            throw new RuntimeException("Customer Not Exists..!");
        }

        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

    public CustomerDTO searchCustomer(String id) {

        for (CustomerDTO customerDTO : DB.customerDB) {
            if (customerDTO.getCusId().equals(id)) {
                return customerDTO;
            }
        }
        return null;

    }

}
