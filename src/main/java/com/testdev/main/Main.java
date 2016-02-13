package com.testdev.main;

import com.testdev.config.SpringFXMLLoader;
import com.testdev.controllers.Controller;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author oleg.krupenya
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = SpringFXMLLoader.load("/sample.fxml");
        Scene scene = new Scene((Parent) controller.getView());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shut down the computer");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

