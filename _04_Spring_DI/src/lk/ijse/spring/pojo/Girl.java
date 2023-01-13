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
public class Girl implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public Girl() {
        System.out.println("Girl: Instantiated");
    }

    public void chat(){
        System.out.println("Hello");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Girl: Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Girl: Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Girl: Bean Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Girl: Bean Initialize: Ready for use");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Girl: Application Context Aware");
    }
}
