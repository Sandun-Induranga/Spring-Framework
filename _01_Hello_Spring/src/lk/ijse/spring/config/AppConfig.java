package lk.ijse.spring.config;

import lk.ijse.spring.pojo.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

//@Configuration
@ComponentScan(basePackages = "lk.ijse.spring")
public class AppConfig {

    public AppConfig() {
        System.out.println("AppConfig: Instantiated");
    }

    @Bean
    public BasicDataSource basicDataSource(){
        return new BasicDataSource();
    }

}
