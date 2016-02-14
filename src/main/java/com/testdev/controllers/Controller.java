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
 * @author oleg.krupenya
 */
public class Controller {
    /**
     * {@link Button} to start the timer
     */
    @FXML
    private Button btnOk;
    /**
     * {@link Spinner} to the hours
     */
    @FXML
    private Spinner nbrHours;
    /**
     * {@link Spinner} to the minutes
     */
    @FXML
    private Spinner nbrMinutes;
    /**
     * {@link Spinner} to the seconds
     */
    @FXML
    private Spinner nbrSeconds;
    /**
     * A loaded object hierarchy from a FXML document.
     */
    private Node view;

    @Autowired
    private ShutdownService shutdownService;


    @FXML
    public void setBtnStartClicked(ActionEvent actionEvent) {
        this.shutdownService.shutdown((Integer) nbrHours.getValue(), (Integer) nbrMinutes.getValue(), (Integer) nbrSeconds.getValue());
        disableComponents();
    }

    @FXML
    public void setBtnCancelClicked(ActionEvent actionEvent) {
        this.shutdownService.cancel();
        enableComponents();
    }

    private void disableComponents() {
        nbrHours.setDisable(true);
        nbrMinutes.setDisable(true);
        nbrSeconds.setDisable(true);
        btnOk.setDisable(true);
    }

    private void enableComponents() {
        nbrHours.setDisable(false);
        nbrMinutes.setDisable(false);
        nbrSeconds.setDisable(false);
        btnOk.setDisable(false);
    }

    /**
     * @return The loaded object hierarchy.
     */
    public Node getView() {
        return view;
    }

    /**
     * Sets the view.
     *
     * @param view The loaded object hierarchy.
     */
    public void setView(Node view) {
        this.view = view;
    }
}
