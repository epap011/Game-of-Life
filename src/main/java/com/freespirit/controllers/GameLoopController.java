package com.freespirit.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class GameLoopController extends Thread {

    private final static int MAX_FPS      = 30;
    private final static int FRAME_PERIOD = 1000/MAX_FPS;
    private int speed                     = 300;
    private boolean running;
    private NavigationBarController navigationBarController;
    private BoardGameController boardGameController;

    public GameLoopController(NavigationBarController navigationBarController, BoardGameController boardGameController) {
        this.navigationBarController = navigationBarController;
        this.boardGameController     = boardGameController;
        this.running                 = false;
        this.initNavigationBarButtonHandlers();
    }

    public void run() {

        while(true) {
            try {
                Thread.sleep(100);
                while (running) {
                    try {
                        Thread.sleep(speed);
                        boardGameController.computeNextGeneration();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void initNavigationBarButtonHandlers() {
        navigationBarController.setStartButtonEventHandler(actionEvent -> handleStartButtonClickEvent());
        navigationBarController.setNextButtonEventHandler(actionEvent  -> handleNextButtonClickEvent());
        navigationBarController.setPauseButtonEventHandler(actionEvent -> handlePauseButtonClickEvent());
        navigationBarController.setSpeedSliderLister(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                System.out.println("Speed " + newValue.intValue() + " ms");
                speed = newValue.intValue();

            }
        });
    }

    private void handleStartButtonClickEvent() {
        running = true;
    }

    private void handleNextButtonClickEvent() {
        boardGameController.computeNextGeneration();
    }

    private void handlePauseButtonClickEvent() {
        running = false;
    }

    private void handleSpeedSliderEvent() {

    }

}
