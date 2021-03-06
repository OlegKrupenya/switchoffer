package com.testdev.config;

import com.testdev.controllers.Controller;
import com.testdev.services.ShutdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration of the application.
 * @author oleg.krupenya
 */
@Configuration
@ComponentScan("com.testdev.services")
public class AppConfig {
    @Bean
    public Controller controller() {
        return new Controller();
    }
}
