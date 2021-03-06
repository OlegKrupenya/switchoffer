package com.testdev.controllers;

import com.testdev.services.ShutdownService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
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
     * Sets the view and initializes event handlers after loading object hierarchy from the FXML document.
     *
     * @param view The loaded object hierarchy.
     */
    public void setView(Node view) {
        this.view = view;
        addEventFilters();
    }

    /**
     * Creates key handler that prevents input of all characters except digits
     */
    private void addEventFilters() {
        EventHandler<KeyEvent> keyPressedEventHandler = event -> {
            String character = event.getCharacter();
            if (character != null) {
                if (!Character.isDigit(character.charAt(0))) {
                    System.out.println(character);
                    event.consume();
                }
            }
        };
        this.nbrHours.addEventFilter(KeyEvent.KEY_TYPED, keyPressedEventHandler);
        this.nbrSeconds.addEventFilter(KeyEvent.KEY_TYPED, keyPressedEventHandler);
        this.nbrMinutes.addEventFilter(KeyEvent.KEY_TYPED, keyPressedEventHandler);
        this.nbrHours.focusedProperty().addListener((s, ov, nv) -> {
            if (nv) return;
            commitEditorText(this.nbrHours);
        });
        this.nbrSeconds.focusedProperty().addListener((s, ov, nv) -> {
            if (nv) return;
            commitEditorText(this.nbrSeconds);
        });
        this.nbrMinutes.focusedProperty().addListener((s, ov, nv) -> {
            if (nv) return;
            commitEditorText(this.nbrMinutes);
        });
    }

    /**
     * c&p from Spinner
     */
    private <T> void commitEditorText(Spinner<T> spinner) {
        if (!spinner.isEditable()) return;
        String text = spinner.getEditor().getText();
        SpinnerValueFactory<T> valueFactory = spinner.getValueFactory();
        if (valueFactory != null) {
            StringConverter<T> converter = valueFactory.getConverter();
            if (converter != null) {
                T value = converter.fromString(text);
                valueFactory.setValue(value);
            }
        }
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
     * Disables all input fields and OK button when the user started the timer.
     */
    private void disableComponents() {
        nbrHours.setDisable(true);
        nbrMinutes.setDisable(true);
        nbrSeconds.setDisable(true);
        btnOk.setDisable(true);
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
     * Enables all components on the form when the user cancelled the timer.
     */
    private void enableComponents() {
        nbrHours.setDisable(false);
        nbrMinutes.setDisable(false);
        nbrSeconds.setDisable(false);
        btnOk.setDisable(false);
    }
}
