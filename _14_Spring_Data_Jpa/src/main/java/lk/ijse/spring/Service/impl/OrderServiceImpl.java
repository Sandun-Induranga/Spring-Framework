package lk.ijse.spring.Service.impl;

import lk.ijse.spring.Service.OrderService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Customer> getAllCustomerIds() {
        return customerRepo.findAll();
    }

    @Override
    public List<Item> getAllItemCodes() {
        return itemRepo.findAll();
    }

    @Override
    public CustomerDTO getCustomer(String cusId) {
        return mapper.map(customerRepo.findById(cusId).get(), CustomerDTO.class);
    }

    @Override
    public ItemDTO getItem(String code) {
        return mapper.map(itemRepo.findById(code).get(), ItemDTO.class);
    }

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        String orderId = "OID002";
        List<OrderDetailDTO> orderDetails = orderDTO.getOrderDetails();
        orderDTO.setOrderId(orderId);
        for (OrderDetailDTO orderDetail : orderDetails) {
            orderDetail.setOrderId(orderId);
        }
        Orders order = mapper.map(orderDTO, Orders.class);
        System.out.println(orderDTO);
        orderRepo.save(order);

//        for (OrderDetailDTO orderDetail : orderDetails) {
//            Item item = itemRepo.findById(orderDetail.getOrderId()).get();
//            item.setQty(item.getQty() - orderDetail.getQty());
//            itemRepo.save(item);
//        }
    }
}
