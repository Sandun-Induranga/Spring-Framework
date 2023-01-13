package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@ComponentScan("lk.ijse.spring")
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig: Instantiated");
    }

    @Bean
    public PojoOne pojoOne(){
        return new PojoOne();
    }
}
