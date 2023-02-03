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

//        if (searchCustomer(customerDTO.getCusId()) != null) {
//            throw new RuntimeException("Customer Already Exists");
//        } else {
//            DB.customerDB.add(customerDTO);
//        }

        repo.save(new Customer(customerDTO.getCusId(),customerDTO.getCusName(),customerDTO.getCusAddress(),customerDTO.getCusSalary()));

        return new ResponseUtil("OK", "Successfully Added..!", "");
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        CustomerDTO customer = searchCustomer(customerDTO.getCusId());

        if (customer != null) {
            customer.setCusName(customerDTO.getCusName());
            customer.setCusAddress(customerDTO.getCusAddress());
            customer.setCusSalary(customerDTO.getCusSalary());
        }

        return new ResponseUtil("200", "Successfully Updated..!", customerDTO);

    }

    @DeleteMapping
    public ResponseUtil deleteCustomer(@RequestParam String cusId) {

        CustomerDTO customer = searchCustomer(cusId);

        if (customer != null) {
            DB.customerDB.remove(customer);
        }else {
            throw new RuntimeException("No Such Customer Id");
        }

        return new ResponseUtil("200", "Successfully Deleted..!", "");

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
