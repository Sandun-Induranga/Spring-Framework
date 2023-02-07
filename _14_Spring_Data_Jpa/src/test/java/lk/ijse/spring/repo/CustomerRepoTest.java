package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebAppConfiguration // Create the testing context
@ContextConfiguration(classes = {WebRootConfig.class}) // Add configuration fot the context
@ExtendWith(SpringExtension.class) // Integrate junit with Spring
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
}