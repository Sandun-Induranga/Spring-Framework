package lk.ijse.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@EnableWebMvc
@ComponentScan({"lk.ijse.spring.pojo", "lk.ijse.spring.controller"})
public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("WebAppConfig: Instantiated");
    }

}
