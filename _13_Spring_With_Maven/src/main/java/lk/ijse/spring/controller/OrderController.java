package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @GetMapping(params = {"cusId"})
    public ResponseUtil getCustomer(String cusId) {

        return new ResponseUtil("200", "Successfully Loaded..!", new CustomerController().searchCustomer(cusId));

    }

    @GetMapping(params = {"code"})
    public ResponseUtil getItem(String code) {

        return new ResponseUtil("200", "Successfully Loaded..!", new ItemController().searchItem(code));

    }

    @PostMapping
    public ResponseUtil placeOrder(OrderDTO orderDTO) {

        System.out.println(orderDTO);
        return new ResponseUtil("200", "Successfully Loaded..!", orderDTO);

    }

}
