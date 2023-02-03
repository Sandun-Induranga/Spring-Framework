package lk.ijse.spring.controller;

import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseUtil getCustomers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", mapper.map(repo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {}.getType()));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {

        if (repo.existsById(customerDTO.getId())) {
            throw new RuntimeException("Customer Already Exists..!");
        }
        repo.save(mapper.map(customerDTO, Customer.class));

        return new ResponseUtil("OK", "Successfully Added..!", "");

    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        if (repo.existsById(customerDTO.getId())) {
            repo.save(mapper.map(customerDTO, Customer.class));
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

        return mapper.map(repo.findById(id).get(), CustomerDTO.class);

    }

}
