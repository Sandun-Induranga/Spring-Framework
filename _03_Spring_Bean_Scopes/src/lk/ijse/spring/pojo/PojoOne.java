package lk.ijse.spring.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PojoOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public PojoOne() {
        System.out.println("PojoOne: Instantiate");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("PojoOne: BeanName Aware : " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("PojoOne: Bean Factory Aware: ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("PojoOne: Application Context Aware");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("PojoOne: Initializing Bean: Bean is ready for use");
    }

    @Override
    //Only invokes, if ctx.close() or ctx.registerShutDownHook() called
    public void destroy() throws Exception {
        System.out.println("PojoOne: Destroyed");
    }
}
