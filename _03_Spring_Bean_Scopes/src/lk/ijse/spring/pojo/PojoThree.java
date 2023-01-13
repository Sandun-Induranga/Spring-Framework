package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class PojoThree implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoThree() {
        System.out.println("PojoThree: Instantiate");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoThree: BeanName Aware : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoThree: Bean Factory Aware: ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoThree: Application Context Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoThree: Initializing Bean: Bean is ready for use");
    }

    @Override
    //Only invokes, if ctx.close() or ctx.registerShutDownHook() called
    public void destroy() throws Exception {
        System.out.println("PojoThree: Destroyed");
    }
}
