package com.freespirit.controllers;

import com.freespirit.model.Universe;

public class GameLoopController extends Thread {

    private final static int MAX_FPS      = 30;
    private final static int FRAME_PERIOD = 1000/MAX_FPS;
    private NavigationBarController navigationBarController;
    private BoardGameController boardGameController;

    public GameLoopController(NavigationBarController navigationBarController, BoardGameController boardGameController) {
        this.navigationBarController = navigationBarController;
        this.boardGameController     = boardGameController;
        this.initNavigationBarButtonHandlers();
    }

    public void run() {

    }

    private void initNavigationBarButtonHandlers() {
        navigationBarController.setStartButtonEventHandler(actionEvent -> handleStartButtonClickEvent());
        navigationBarController.setNextButtonEventHandler(actionEvent  -> handleNextButtonClickEvent());
        navigationBarController.setPauseButtonEventHandler(actionEvent -> handlePauseButtonClickEvent());
    }

    private void handleStartButtonClickEvent() {
        System.out.println("start button pressed");
    }

    private void handleNextButtonClickEvent() {
        System.out.println("next button pressed");
        boardGameController.computeNextGeneration();
    }

    private void handlePauseButtonClickEvent() {
        System.out.println("pause button pressed");
    }

    private void updateGameState() {
    }

    private void displayGameState() {

    }
}
