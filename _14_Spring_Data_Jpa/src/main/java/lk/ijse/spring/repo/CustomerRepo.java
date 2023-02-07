package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    long countCustomerByName(String name);

    boolean existsCustomerByAddress(String address);

    void deleteCustomerByAddress(String address);
    void removeCustomerByName(String name);

    @Query(value = "SELECT * FROM Customer", nativeQuery = true)
    ArrayList<Customer> methodOne();

    @Query(value = "SELECT * FROM Customer WHERE id='C001'", nativeQuery = true)
    ArrayList<Customer> methodTwo();

    @Query(value = "SELECT * FROM Customer WHERE id=?1", nativeQuery = true)
    ArrayList<Customer> methodThree(String id, String name);

}
