package lk.ijse.spring.Service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public interface CustomerService {

    public void saveCustomer(CustomerDTO customerDTO);
    public void updateCustomer(CustomerDTO customerDTO);
    public void deleteCustomer(String cusId);
    public ArrayList<CustomerDTO> getAllCustomer();

}
