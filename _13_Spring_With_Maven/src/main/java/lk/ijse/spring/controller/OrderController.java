package lk.ijse.spring.controller;

import lk.ijse.spring.db.DB;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

//    @GetMapping
//    public ResponseUtil getAllOrders() {
//
//        return new ResponseUtil("200", "Successfully Loaded..!", DB.customerDB);
//
//    }

}
