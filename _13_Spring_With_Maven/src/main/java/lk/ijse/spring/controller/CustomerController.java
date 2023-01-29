package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.http.HttpStatus;
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

        dtos.add(new CustomerDTO("C001", "Dasun", "Galle", 10000));
        dtos.add(new CustomerDTO("C002", "Dasuni", "Colombo", 25000));
        dtos.add(new CustomerDTO("C003", "Ashan", "Matara", 10000));
        dtos.add(new CustomerDTO("C004", "Ashani", "Galle", 15000));
        dtos.add(new CustomerDTO("C005", "Ramal", "Galle", 15000));
        dtos.add(new CustomerDTO("C006", "Ranmali", "Kandy", 15000));

        return new ResponseUtil("200", "Successfully Loaded..!", dtos);

    }

    // @ModelAttribute not compulsory
    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED) // 201
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customerDTO) {

        System.out.println(customerDTO);

        if (customerDTO.getId().equals("C001")) {
            throw new RuntimeException("Customer Already Exists");
        }

        return new ResponseUtil("200", "Successfully Added..!", customerDTO);
    }

    @PutMapping
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseUtil("200", "Successfully Updated..!", dtos);
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
