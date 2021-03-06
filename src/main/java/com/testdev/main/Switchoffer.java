package com.testdev.main;

import com.testdev.config.SpringFXMLLoader;
import com.testdev.controllers.Controller;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class.
 * @author oleg.krupenya
 */
public class SwitchOffer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = SpringFXMLLoader.load("/switchoffer.fxml");
        Scene scene = new Scene((Parent) controller.getView(), 255, 240);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SwitchOffer");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

