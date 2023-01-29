package lk.ijse.spring.controller;

import lk.ijse.spring.db.DB;
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

        if (DB.customerDB.isEmpty()) {
            DB.customerDB.add(new CustomerDTO("C001", "Dasun", "Galle", 10000));
            DB.customerDB.add(new CustomerDTO("C002", "Dasuni", "Colombo", 25000));
            DB.customerDB.add(new CustomerDTO("C003", "Ashan", "Matara", 10000));
            DB.customerDB.add(new CustomerDTO("C004", "Ashani", "Galle", 15000));
            DB.customerDB.add(new CustomerDTO("C005", "Ramal", "Galle", 15000));
            DB.customerDB.add(new CustomerDTO("C006", "Ranmali", "Kandy", 15000));
        }

        return new ResponseUtil("200", "Successfully Loaded..!", DB.customerDB);

    }

    // @ModelAttribute not compulsory
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {

        DB.customerDB.add(customerDTO);

        if (customerDTO.getCusId().equals("C001")) {
            throw new RuntimeException("Customer Already Exists");
        }

        return new ResponseUtil("200", "Successfully Added..!", "");
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        System.out.println(customerDTO);

        return new ResponseUtil("200", "Successfully Updated..!", customerDTO);
    }

    @DeleteMapping(params = "{id}")
    public ResponseUtil deleteCustomer(@RequestParam String id) {

        System.out.println(id);

        if (id.equals("C001")) {
            throw new RuntimeException("No Such Customer Id");
        }

        return new ResponseUtil("200", "Successfully Deleted..!", "");
    }

}
