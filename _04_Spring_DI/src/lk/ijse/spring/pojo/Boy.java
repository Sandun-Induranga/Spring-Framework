package lk.ijse.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Boy {

    @Autowired
    Girl girl;

    public Boy() {
        System.out.println("Boy: Instantiated");
    }

    public void chatWithGirl(){
//        Girl girl = new Girl();    // Don't create objects
        girl.chat();
    }

}
