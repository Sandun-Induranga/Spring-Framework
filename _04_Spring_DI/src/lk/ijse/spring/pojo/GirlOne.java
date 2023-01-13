package lk.ijse.spring.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
@Primary
public class GirlOne implements GoodGirl {

    public GirlOne() {
        System.out.println("GirlOne: Instantiated");
    }

    public void chat(){
        System.out.println("GirlOne: Hello");
    }

}
