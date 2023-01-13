package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class Girl implements GoodGirl {

    public Girl() {
        System.out.println("Girl: Instantiated");
    }

    public void chat(){
        System.out.println("Hello");
    }

}
