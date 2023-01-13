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

public class PojoTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoTwo() {
        System.out.println("PojoTwo: Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoTwo: Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoTwo: Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoTwo: Bean Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoTwo: Bean Initialized and can use");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoTwo: Application Context Aware");
    }

}
