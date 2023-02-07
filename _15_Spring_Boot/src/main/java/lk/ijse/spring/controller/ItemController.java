package lk.ijse.spring.controller;


import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        System.out.println(itemDTO);
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
