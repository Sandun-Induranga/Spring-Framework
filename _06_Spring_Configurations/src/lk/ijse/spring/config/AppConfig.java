package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@ComponentScan("lk.ijse.spring.pojo")
@Import({ConfigOne.class, ConfigTwo.class}) // Method Two
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig: Instantiated");
    }

    @Bean
    public PojoOne pojoOne(){
        return new PojoOne();
    }
}
