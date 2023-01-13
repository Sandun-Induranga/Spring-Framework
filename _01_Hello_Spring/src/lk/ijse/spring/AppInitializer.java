package lk.ijse.spring;

import lk.ijse.spring.config.AppConfig;
import lk.ijse.spring.pojo.BasicDataSource;
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

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);

        ctx.refresh();

        Customer c1 = ctx.getBean(Customer.class);
        c1.getCustomerName();

        Customer c2 = ctx.getBean(Customer.class);

        System.out.println(c1 == c2); // Returns true

        PojoOne p1 = ctx.getBean(PojoOne.class);

        DBConnection dbConnection = ctx.getBean(DBConnection.class);
        dbConnection.testConnection();

        BasicDataSource basicDataSource = ctx.getBean(BasicDataSource.class);
        basicDataSource.getDataSource();


        //    ***********************    Bean ID    ****************************

        //    Customer -> customer - First letter simple

        Customer customer = (Customer) ctx.getBean("customer");
        customer.getCustomerName();
        System.out.println(customer == c1);

        PojoOne pojoone = (PojoOne) ctx.getBean("pojoOne");
        System.out.println(pojoone);


        // If use @Bean annotation, then should use method name as bean id

        BasicDataSource basicDataSource1 = (BasicDataSource) ctx.getBean("dd");
        System.out.println(basicDataSource1);


        // Give bean id

        DBConnection database = (DBConnection) ctx.getBean("database");
        System.out.println(database);


        ctx.close();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JVM is About to Shutdown");
            }
        }));

    }

}
