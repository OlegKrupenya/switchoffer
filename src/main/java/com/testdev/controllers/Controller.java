package com.testdev.controllers;

import com.testdev.services.ShutdownService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller of the application.
 */
public class Controller {

    /**
     * Container of the buttons.
     */
    @FXML
    private VBox btnContainer;
    /**
     * Label that displays information to the user.
     */
    @FXML
    private Label lblResult;
    @FXML
    private Button btnStart;

    /**
     * A loaded object hierarchy from a FXML document.
     */
    private Node view;

    @Autowired
    private ShutdownService shutdownService;


    @FXML
    public void setBtnStartClicked(ActionEvent actionEvent) {
        int hours = 0;
        int minutes = 0;
        this.shutdownService.shutdown(hours, minutes);
    }

    /**
     * Sets the view.
     * @param view The loaded object hierarchy.
     */
    public void setView(Node view) {
        this.view = view;
    }

    /**
     * @return The loaded object hierarchy.
     */
    public Node getView() {
        return view;
    }

    public void setShutdownService(ShutdownService shutdownService) {
        this.shutdownService = shutdownService;
    }
}
