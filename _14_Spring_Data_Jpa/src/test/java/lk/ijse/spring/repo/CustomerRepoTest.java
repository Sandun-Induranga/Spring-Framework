package lk.ijse.spring.repo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@WebAppConfiguration // Create the testing context
@ContextConfiguration // Add configuration fot the context
@ExtendWith(SpringExtension.class) // Integrate junit with Spring
class CustomerRepoTest {

    @Test
    void findByName() {
    }
}