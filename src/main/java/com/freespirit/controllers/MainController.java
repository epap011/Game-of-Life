package com.freespirit.controllers;

import com.freespirit.model.Universe;
import javafx.fxml.FXML;

public class MainController {

    @FXML private BoardGameController boardGameController;
    @FXML private NavigationBarController navigationBarController;
    private GameLoopController gameLoopController;

    @FXML private void initialize() {
        Universe universe = new Universe(100, 100);

        boardGameController.setUniverse(universe);

        universe.getGrid().getCells().get(20).get(35).born();
        universe.getGrid().getCells().get(21).get(36).born();
        universe.getGrid().getCells().get(22).get(36).born();
        universe.getGrid().getCells().get(22).get(35).born();
        universe.getGrid().getCells().get(22).get(34).born();

        gameLoopController = new GameLoopController(navigationBarController, boardGameController);
        gameLoopController.start();
    }

}