package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoThree;
import lk.ijse.spring.pojo.PojoTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
public class ConfigTwo {

    public ConfigTwo() {
        System.out.println("ConfigTwo: Instantiated");
    }

    @Bean
    public PojoThree pojoThree(){
        return new PojoThree();
    }
}
