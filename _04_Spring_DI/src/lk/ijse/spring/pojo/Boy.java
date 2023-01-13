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
public class Boy implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    @Autowired
    Girl girl;

    public Boy() {
        System.out.println("Boy: Instantiated");
    }

    public void chatWithGirl() {
//        Girl girl = new Girl();    // Don't create objects
        girl.chat();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Boy: Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Boy: Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Boy: Bean Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Boy: Bean Initialize: Ready for use");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Boy: Application Context Aware");
    }
}
