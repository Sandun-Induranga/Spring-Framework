package lk.ijse.spring.config;

import lk.ijse.spring.Service.CustomerService;
import lk.ijse.spring.Service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {CustomerService.class, ItemService.class})
public class WebRootConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
