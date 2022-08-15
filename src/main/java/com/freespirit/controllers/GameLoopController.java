package com.freespirit.controllers;

public class GameLoopController extends Thread {

    private final static int MAX_FPS      = 30;
    private final static int FRAME_PERIOD = 1000/MAX_FPS;
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
            while (running) {
                try {
                    Thread.sleep(400);
                    boardGameController.computeNextGeneration();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void initNavigationBarButtonHandlers() {
        navigationBarController.setStartButtonEventHandler(actionEvent -> handleStartButtonClickEvent());
        navigationBarController.setNextButtonEventHandler(actionEvent  -> handleNextButtonClickEvent());
        navigationBarController.setPauseButtonEventHandler(actionEvent -> handlePauseButtonClickEvent());
    }

    private void handleStartButtonClickEvent() {
        running = true;
    }

    private void handleNextButtonClickEvent() {
        System.out.println("next button pressed");
        boardGameController.computeNextGeneration();
    }

    private void handlePauseButtonClickEvent() {
        System.out.println("pause button pressed");
        running = false;
    }

    private void updateGameState() {
    }

    private void displayGameState() {

    }
}
