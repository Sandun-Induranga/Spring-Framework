package lk.ijse.spring.controller;


import lk.ijse.spring.Service.ItemService;
import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseUtil getItems() {

        return new ResponseUtil("OK", "Successfully Loaded..!", itemService.getAllItems());

    }

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {

        itemService.saveItem(itemDTO);
        return new ResponseUtil("OK", "Successfully Added..!", "");

    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {

        itemService.updateItem(itemDTO);
        return new ResponseUtil("200", "Successfully Updated..!", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String code) {

        itemService.deleteItem(code);
        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

}
