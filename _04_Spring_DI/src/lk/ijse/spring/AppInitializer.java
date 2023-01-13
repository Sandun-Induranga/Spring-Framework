package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.Boy;
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

        Boy boy = ctx.getBean(Boy.class);
        System.out.println(boy);

        ctx.registerShutdownHook();

    }
}