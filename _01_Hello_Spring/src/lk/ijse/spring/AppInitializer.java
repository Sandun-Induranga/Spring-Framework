package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.Customer;
import lk.ijse.spring.pojo.DBConnection;
import lk.ijse.spring.pojo.PojoOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

public class AppInitializer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);

        ctx.refresh();

        Customer c1 = ctx.getBean(Customer.class);
        c1.getCustomerName();

        Customer c2 = ctx.getBean(Customer.class);
        c2.getCustomerName();

        PojoOne p1 = ctx.getBean(PojoOne.class);

        DBConnection dbConnection = ctx.getBean(DBConnection.class);
        dbConnection.testConnection();

        ctx.close();

    }

}
