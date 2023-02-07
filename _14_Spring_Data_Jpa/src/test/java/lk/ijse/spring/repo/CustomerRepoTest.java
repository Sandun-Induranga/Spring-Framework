package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebAppConfiguration // Create the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // Add configuration fot the context
@ExtendWith(SpringExtension.class) // Integrate junit with Spring
@Transactional
class CustomerRepoTest {

    @Autowired
    CustomerRepo customerRepo;

    @Test
    void findCustomerByName() {
        ArrayList<Customer> arrayList = customerRepo.findCustomerByName("Dasun");
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
    }

    @Test
    void findByName() {
        ArrayList<Customer> arrayList = customerRepo.findByName("Dasun");
        for (Customer customer : arrayList) {
            System.out.println(customer);
        }
    }

    @Test
    void testAllMethods() {
        ArrayList<Customer> c = customerRepo.findCustomerByName("Dasun");
        ArrayList<Customer> c1 = customerRepo.readCustomerByName("Dasun");
        ArrayList<Customer> c2 = customerRepo.getCustomerByName("Dasun");
        ArrayList<Customer> c3 = customerRepo.queryCustomerByName("Dasun");
        ArrayList<Customer> c4 = customerRepo.searchCustomerByName("Dasun");
        ArrayList<Customer> c5 = customerRepo.streamCustomerByName("Dasun");

        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);

        long count = customerRepo.countCustomerByName("Dasun");
        System.out.println(count);

        boolean exists = customerRepo.existsCustomerByAddress("Colombo");
        System.out.println(exists);

        customerRepo.deleteCustomerByAddress("Colombo");

        customerRepo.removeCustomerByName("Dasun");

    }

}
