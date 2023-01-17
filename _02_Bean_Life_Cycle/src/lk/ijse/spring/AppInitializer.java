package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.PojoOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        System.out.println(ctx.getBean(PojoOne.class));

        ctx.registerShutdownHook();

        /*                         Spring Bean Life Cycle
        *
        *       1. Instantiate                      -    Create an object
        *       2. Populate Properties              -    Read Properties
        *       3. Bean Name Awareness              -    Set the Bean Name (id)
        *       4. Bean Factory Awareness           -    Set DI features
        *       5. Application Context Awareness    -    AOP, Declarative Programming
        *       6. Initializing Bean                -    Bean is ready for use
        *       6. Disposable Bean                  -    Bean is Destroyed
        *
        *  */

    }
}
