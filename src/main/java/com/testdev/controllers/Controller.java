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
     * Service that shuts down the computer by the timer
     */
    @Autowired
    private ShutdownService shutdownService;
    /**
     * A loaded object hierarchy from a FXML document.
     */
    private Node view;

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

    /**
     * Shuts down the computer by timer when the user clicks OK button.
     * Disables all input fields and OK button.
     */
    @FXML
    public void setBtnStartClicked() {
        this.shutdownService.shutdown((Integer) nbrHours.getValue(), (Integer) nbrMinutes.getValue(), (Integer) nbrSeconds.getValue());
        disableComponents();
    }

    /**
     * Cancels the timer.
     * Enables all components on the form.
     */
    @FXML
    public void setBtnCancelClicked() {
        this.shutdownService.cancel();
        enableComponents();
    }

    /**
     * Disables all input fields and OK button when the user started the timer.
     */
    private void disableComponents() {
        nbrHours.setDisable(true);
        nbrMinutes.setDisable(true);
        nbrSeconds.setDisable(true);
        btnOk.setDisable(true);
    }

    /**
     * Enables all components on the form when the user cancelled the timer.
     */
    private void enableComponents() {
        nbrHours.setDisable(false);
        nbrMinutes.setDisable(false);
        nbrSeconds.setDisable(false);
        btnOk.setDisable(false);
    }
}
