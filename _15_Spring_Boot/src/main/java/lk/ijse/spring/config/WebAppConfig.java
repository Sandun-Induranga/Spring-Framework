package lk.ijse.spring.config;

import lk.ijse.spring.advicer.AppWideExceptionHandler;
import lk.ijse.spring.controller.CustomerController;
import lk.ijse.spring.controller.ItemController;
import lk.ijse.spring.controller.OrderDetailController;
import lk.ijse.spring.controller.PurchaseOrderController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {CustomerController.class, ItemController.class, PurchaseOrderController.class, OrderDetailController.class, AppWideExceptionHandler.class})
public class WebAppConfig {



}
