package lk.ijse.spring.pojo;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component()
public class Customer {
    public Customer() {
        System.out.println("Customer: Instantiated");
    }

    public void getCustomerName(){
        System.out.println("Customer Name is Dasun");
    }
}
