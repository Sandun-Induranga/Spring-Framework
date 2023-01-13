package lk.ijse.spring.pojo;

import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class GirlTwo implements GoodGirl{

    public GirlTwo() {
        System.out.println("GirlTwo: Instantiated");
    }
    @Override
    public void chat() {
        System.out.println("GirlTwo: Hello");
    }
}
