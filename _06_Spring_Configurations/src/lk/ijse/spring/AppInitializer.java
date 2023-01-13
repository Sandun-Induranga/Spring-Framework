package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.config.ConfigOne;
import lk.ijse.spring.config.ConfigTwo;
import lk.ijse.spring.pojo.PojoOne;
import lk.ijse.spring.pojo.PojoThree;
import lk.ijse.spring.pojo.PojoTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class AppInitializer {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        // Method One
        ctx.register(AppConfig.class);
//        ctx.register(ConfigOne.class);
//        ctx.register(ConfigTwo.class);

        ctx.refresh();

        PojoOne pojoOne = ctx.getBean(PojoOne.class);
        PojoTwo pojoTwo = ctx.getBean(PojoTwo.class);
        PojoThree pojoThree = ctx.getBean(PojoThree.class);

        System.out.println(pojoOne);
        System.out.println(pojoTwo);
        System.out.println(pojoThree);

        ctx.registerShutdownHook();

    }
}