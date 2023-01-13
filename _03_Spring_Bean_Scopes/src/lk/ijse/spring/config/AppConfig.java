package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoThree;
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

    @Bean
    public PojoThree pojoThree(){
        return new PojoThree();
    }

}
