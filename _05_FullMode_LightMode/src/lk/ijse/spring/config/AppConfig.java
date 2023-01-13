package lk.ijse.spring.config;

import lk.ijse.spring.pojo.PojoThree;
import lk.ijse.spring.pojo.PojoTwo;
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

    // Full Mode
    @Bean
    public PojoTwo pojoTwo(){

        // Inter-Bean dependencies Innovation
        // In Full Mode, Satisfied Inter-Bean Dependencies

        PojoThree pojoThree = pojoThree();
        PojoThree pojoThree1 = pojoThree();

        System.out.println(pojoThree);
        System.out.println(pojoThree1);

        return new PojoTwo();
    }

    @Bean
    public PojoThree pojoThree(){
        return new PojoThree();
    }

}
