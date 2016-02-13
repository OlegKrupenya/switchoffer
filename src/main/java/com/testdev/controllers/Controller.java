package com.testdev.controllers;

import com.testdev.services.ShutdownService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Controller of the application.
 */
public class Controller {

    @FXML
    private Button btnOk;
    @FXML
    private Spinner nbrHours;
    @FXML
    private Spinner nbrMinutes;

    /**
     * A loaded object hierarchy from a FXML document.
     */
    private Node view;

    @Autowired
    private ShutdownService shutdownService;


    @FXML
    public void setBtnStartClicked(ActionEvent actionEvent) {
        this.shutdownService.shutdown((Integer) nbrHours.getValue(), (Integer) nbrMinutes.getValue());
        disableComponents();
    }

    private void disableComponents() {
        nbrHours.setDisable(true);
        nbrMinutes.setDisable(true);
        btnOk.setDisable(true);
    }

    /**
     * Sets the view.
     *
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
