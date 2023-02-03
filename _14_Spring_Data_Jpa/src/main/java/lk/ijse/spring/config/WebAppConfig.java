package lk.ijse.spring.config;

import lk.ijse.spring.advicer.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.ItemController;
import lk.ijse.spring.controller.OrderController;
import lk.ijse.spring.controller.OrderDetailController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.modelmapper.ModelMapper;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, ItemController.class, OrderController.class, OrderDetailController.class, AppWideExceptionHandler.class})
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
