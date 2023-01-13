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
public class PojoTwo implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoTwo() {
        System.out.println("PojoTwo: Instantiate");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoTwo: BeanName Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoTwo: Bean Factory Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoTwo: Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoTwo: Initializing Bean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoTwo: Application Context Aware");
    }
}
