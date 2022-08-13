package com.freespirit.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavigationBarController {

    @FXML private HBox navBar;
    @FXML private Button startButton;
    @FXML private Button nextButton;
    @FXML private Button pauseButton;

    public void setStartButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        startButton.setOnAction(eventHandler);
    }

    public void setNextButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        nextButton.setOnAction(eventHandler);
    }

    public void setPauseButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        pauseButton.setOnAction(eventHandler);
    }
}
