package com.testdev.config;

import com.testdev.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Custom loader that is needed for Spring in JavaFX applications.
 * Created by oleh.krupenia on 7/17/2015.
 */
public class SpringFXMLLoader {
    private static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);

    /**
     * Loads FXML file and creates a contoller
     * @param url Path to the resource
     * @return Controller
     */
    public static Controller load(String url) {
        try (InputStream fxmlStream = SpringFXMLLoader.class.getResourceAsStream(url)) {

            FXMLLoader loader = new FXMLLoader();
            loader.setControllerFactory(APPLICATION_CONTEXT::getBean);

            Node view = loader.load(fxmlStream);
            Controller controller = loader.getController();
            controller.setView(view);

            return controller;
        } catch (IOException e) {
            System.out.println("Can't load resource");
            throw new RuntimeException(e);
        }
    }
}