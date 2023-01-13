package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Girl {

    public Girl() {
        System.out.println("Girl: Instantiated");
    }

    public void chat(){
        System.out.println("Hello");
    }
}
