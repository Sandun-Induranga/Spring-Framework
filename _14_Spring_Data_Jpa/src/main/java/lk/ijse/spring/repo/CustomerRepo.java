package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public interface CustomerRepo extends JpaRepository<Customer, String> {

    ArrayList<Customer> findCustomerByName(String name);

    ArrayList<Customer> findByName(String name);

    ArrayList<Customer> readCustomerByName(String name);

    ArrayList<Customer> getCustomerByName(String name);

    ArrayList<Customer> queryCustomerByName(String name);

    ArrayList<Customer> searchCustomerByName(String name);

    ArrayList<Customer> streamCustomerByName(String name);

    ArrayList<Customer> countCustomerByName(String name);

    boolean existsCustomerByAddress(String address);

    ArrayList<Customer> deleteCustomerByAddress(String address);
    ArrayList<Customer> removeCustomerByName(String name);

}
