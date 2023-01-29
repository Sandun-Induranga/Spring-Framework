package lk.ijse.spring.controller;


import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    @GetMapping
    public ResponseUtil getItems() {

        if (DB.itemDB.isEmpty()){
            DB.itemDB.add(new ItemDTO("ITM-001","Rice",10,1000));
            DB.itemDB.add(new ItemDTO("ITM-002","Rice",10,1000));
            DB.itemDB.add(new ItemDTO("ITM-003","Rice",10,1000));
            DB.itemDB.add(new ItemDTO("ITM-004","Rice",10,1000));
            DB.itemDB.add(new ItemDTO("ITM-005","Rice",10,1000));
            DB.itemDB.add(new ItemDTO("ITM-006","Rice",10,1000));
        }

        System.out.println(DB.itemDB);

        return new ResponseUtil("200", "Successfully Loaded..!", DB.itemDB);

    }

    // @ModelAttribute not compulsory
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseUtil("200","Successfully Added..!", dtos);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody CustomerDTO customerDTO){

        System.out.println(customerDTO);
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        dtos.add(customerDTO);

        return new ResponseUtil("200","Successfully Updated..!", dtos);
    }

    @DeleteMapping(params = "{id}")
    public ResponseUtil deleteItem(@RequestParam String id){

        System.out.println(id);

        return new ResponseUtil("200","Successfully Deleted..!", "");
    }

}
