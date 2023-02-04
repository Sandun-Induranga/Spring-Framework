package lk.ijse.spring.controller;

import lk.ijse.spring.Service.OrderService;
import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(params = {"cusId"})
    public ResponseUtil getCustomer(String cusId) {
        return new ResponseUtil("200", "Successfully Loaded..!", orderService.getCustomer(cusId));
    }

    @GetMapping(params = {"code"})
    public ResponseUtil getItem(String code) {
        return new ResponseUtil("200", "Successfully Loaded..!", orderService.getItem(code));
    }

    @PostMapping
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseUtil("200", "Order Placed..!", "");
    }

    public String generateNewOrderId() {

        if (DB.orderDB.size() != 0) {
            String lastId = DB.orderDB.get(DB.orderDB.size() - 1).getOrderId();
            return String.format("OID%03d", (Integer.parseInt(lastId.replace("OID", "")) + 1));
        }
        return "OID001";
    }

}
