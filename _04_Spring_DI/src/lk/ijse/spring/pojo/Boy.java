package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Boy {

    @Autowired
//    GoodGirl girl; // When there are two qualify classes It will throw error
    GoodGirl girl; // @Primary annotation solve it

    public Boy() {
        System.out.println("Boy: Instantiated");
    }

    public void chatWithGirl() {
//        Girl girl = new Girl();    // Don't create objects
        girl.chat();
    }

}
