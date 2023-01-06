package lk.ijse.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.close();
    }
}
