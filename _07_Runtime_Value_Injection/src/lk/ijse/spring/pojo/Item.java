package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Item implements InitializingBean {

    @Value("IJSE")
    String name;

    public Item() {
        System.out.println("Item: Instantiated");
        System.out.println(name); // returns null As this bean not ready yet.
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name); // returns IJSE as this bean ready now.
    }
}
