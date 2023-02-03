package lk.ijse.spring.controller;

import lk.ijse.spring.db.DB;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ItemRepo itemRepo;

    @GetMapping(params = {"cusId"})
    public ResponseUtil getCustomer(String cusId) {

        return new ResponseUtil("200", "Successfully Loaded..!", customerRepo.findById(cusId).get());

    }

    @GetMapping(params = {"code"})
    public ResponseUtil getItem(String code) {

        return new ResponseUtil("200", "Successfully Loaded..!", itemRepo.findById(code).get());

    }

    @PostMapping
    public ResponseUtil placeOrder(@RequestBody OrderDTO orderDTO) {

        String orderId = generateNewOrderId();
        orderDTO.setOrderId(orderId);

        List<OrderDetailDTO> orderDetails = orderDTO.getOrderDetails();
        for (OrderDetailDTO orderDetail : orderDetails) {
            orderDetail.setOrderId(orderId);
            DB.orderDetailDB.add(orderDetail);
        }

        DB.orderDB.add(orderDTO);

        System.out.println(orderDTO);
        return new ResponseUtil("200", "Order Placed..!", orderDTO);

    }

    public String generateNewOrderId() {

        if (DB.orderDB.size() != 0) {
            String lastId = DB.orderDB.get(DB.orderDB.size() - 1).getOrderId();
            return String.format("OID%03d", (Integer.parseInt(lastId.replace("OID", "")) + 1));
        }
        return "OID001";
    }

}
