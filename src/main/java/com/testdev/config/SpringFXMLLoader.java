package com.testdev.config;

import com.testdev.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.InputStream;

/**
 * Custom loader that is needed for Spring in JavaFX applications.
 * @author oleg.krupenya
 */
public class SpringFXMLLoader {
    /**
     * Interface of the Spring configuration for the application.
     */
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringFXMLLoader.class);

    /**
     * Loads FXML file and creates a controller
     * @param url Path to the resource
     * @return Controller
     */
    public static Controller load(String url)  {
        try (InputStream fxmlStream = SpringFXMLLoader.class.getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(APPLICATION_CONTEXT::getBean);
            Node view = loader.load(fxmlStream);
            Controller controller = loader.getController();
            controller.setView(view);
            return controller;
        } catch (Exception e) {
            LOGGER.error("Unable to load the resource {}", url, e);
        }
        return null;
    }
}