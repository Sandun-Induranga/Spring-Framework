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

        if (DB.itemDB.isEmpty()) {
            DB.itemDB.add(new ItemDTO("ITM-001", "Rice", 550, 10));
            DB.itemDB.add(new ItemDTO("ITM-002", "Dahl", 320, 25));
            DB.itemDB.add(new ItemDTO("ITM-003", "Biscuit", 110, 18));
            DB.itemDB.add(new ItemDTO("ITM-004", "Sugar", 325, 20));
            DB.itemDB.add(new ItemDTO("ITM-005", "Soap", 60, 16));
        }

        return new ResponseUtil("200", "Successfully Loaded..!", DB.itemDB);

    }

    // @ModelAttribute not compulsory
    @PostMapping
    public ResponseUtil saveItem(@ModelAttribute ItemDTO itemDTO) {

        DB.itemDB.add(itemDTO);

        return new ResponseUtil("200", "Successfully Added..!", "");
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {

        ItemDTO searchItem = searchItem(itemDTO.getCode());

        if (searchItem!=null){
            searchItem.setName(itemDTO.getName());
            searchItem.setPrice(itemDTO.getPrice());
            searchItem.setQty(itemDTO.getQty());
        }

        return new ResponseUtil("200", "Successfully Updated..!", "");
    }

    @DeleteMapping(params = "{id}")
    public ResponseUtil deleteItem(@RequestParam String id) {

        System.out.println(id);

        return new ResponseUtil("200", "Successfully Deleted..!", "");
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
