package lk.ijse.spring.di;

import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class B implements SuperB {

    public B() {
        System.out.println("B: Instantiated");
    }

    public void  methodUseByA(){
        System.out.println("Method Invoked By A");
    }

}
