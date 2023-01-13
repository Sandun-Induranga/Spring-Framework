package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Customer {

    public Customer(@Value("ijse") String name) {
        System.out.println("Customer: Instantiated " + name);
    }

}
