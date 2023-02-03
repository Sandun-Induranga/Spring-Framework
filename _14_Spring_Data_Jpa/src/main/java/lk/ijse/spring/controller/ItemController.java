package lk.ijse.spring.controller;


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
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public ResponseUtil getItems() {

        return new ResponseUtil("OK", "Successfully Loaded..!", mapper.map(repo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {}.getType()));

    }

    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {

        if (repo.existsById(itemDTO.getCode())) {
            throw new RuntimeException("Item Already Exists..!");
        }
        repo.save(mapper.map(itemDTO, Item.class));

        return new ResponseUtil("OK", "Successfully Added..!", "");

    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {

        if (repo.existsById(itemDTO.getCode())) {
            repo.save(mapper.map(itemDTO, Item.class));
        } else {
            throw new RuntimeException("Item Not Exists..!");
        }
        return new ResponseUtil("200", "Successfully Updated..!", "");
    }

    @DeleteMapping
    public ResponseUtil deleteItem(String code) {

        if (repo.existsById(code)) {
            repo.deleteById(code);
        } else {
            throw new RuntimeException("Item Not Exists..!");
        }

        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

    public ItemDTO searchItem(String code) {

        for (ItemDTO itemDTO : DB.itemDB) {
            if (itemDTO.getCode().equals(code)) {
                return itemDTO;
            }
        }
        return null;

    }

}
