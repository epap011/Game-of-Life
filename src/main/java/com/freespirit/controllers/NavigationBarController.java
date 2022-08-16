package com.freespirit.controllers;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class NavigationBarController {

    @FXML private HBox gameStateButtonBox;
    @FXML private Button startButton;
    @FXML private Button nextButton;
    @FXML private Button pauseButton;
    @FXML private Slider speedSlider;

    public void setStartButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        startButton.setOnAction(eventHandler);
    }

    public void setNextButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        nextButton.setOnAction(eventHandler);
    }

    public void setPauseButtonEventHandler(EventHandler<ActionEvent> eventHandler) {
        pauseButton.setOnAction(eventHandler);
    }

    public void setSpeedSliderLister(ChangeListener<Number> changeListener) {
        speedSlider.valueProperty().addListener(changeListener);
    }
}
