package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.dto.OrderDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Item;

import java.util.List;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public interface OrderService {
    public List<Customer> getAllCustomerIds();
    public List<Item> getAllItemCodes();
    public CustomerDTO getCustomer(String cusId);
    public ItemDTO getItem(String code);
    public void placeOrder(OrderDTO orderDTO);
}
