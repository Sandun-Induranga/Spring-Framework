package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;


    @Test
    void saveCustomer() {

        // Valid Data Test
        customerService.saveCustomer(new CustomerDTO("C005", "John", "England", 1000));

        // Invalid Data Test
        assertThrows(RuntimeException.class, () -> {
            customerService.saveCustomer(new CustomerDTO("C001", "John", "England", 1000));
        });

    }

    @Test
    void updateCustomer() {

        assertDoesNotThrow(() -> {
            customerService.updateCustomer(new CustomerDTO("C002", "John", "America", 1000));
        });

        assertThrows(RuntimeException.class, () -> {
            customerService.updateCustomer(new CustomerDTO("C005", "John", "England", 1000));
        });

    }

    @Test
    void deleteCustomer() {
        assertDoesNotThrow(() -> {
            customerService.deleteCustomer("C001");
        });

        assertThrows(RuntimeException.class, () -> {
            customerService.deleteCustomer("C010");
        });

    }

    @Test
    void getAllCustomer() {
        assertNotNull(customerService.getAllCustomer());
    }

    @Test
    void searchCustomer() {
        customerService.searchCustomer("Dasun");
    }

}