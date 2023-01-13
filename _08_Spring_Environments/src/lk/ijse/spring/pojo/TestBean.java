package lk.ijse.spring.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class TestBean implements InitializingBean {

    @Autowired
    Environment environment;

    public TestBean() {
        System.out.println("TestBean: Instantiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String property = environment.getProperty("db.user.password"); // If the key is not available returns null
//        String property = environment.getRequiredProperty("db.user.password"); // If the key is not available throws an Exception
        System.out.println(property);
    }
}
