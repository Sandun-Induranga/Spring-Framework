package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
public class PojoOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoOne() {
        System.out.println("PojoOne: Instantiated");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoOne: Bean Factory Aware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoOne: Bean Name Aware");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("PojoOne: Bean Destroyed");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoOne: Bean Initialized and can use");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoOne: Application Context Aware");
    }

    // Light Mode
    @Bean
    public PojoTwo pojoTwo() {

        // In Light Mode, not Satisfied Inter-Bean Dependencies
        PojoThree pojoThree = pojoThree();
        PojoThree pojoThree1 = pojoThree();

        System.out.println(pojoThree);
        System.out.println(pojoThree1);
        System.out.println(pojoThree == pojoThree1);

        return new PojoTwo();
    }

    @Bean
    public PojoThree pojoThree() {
        return new PojoThree();
    }

}
