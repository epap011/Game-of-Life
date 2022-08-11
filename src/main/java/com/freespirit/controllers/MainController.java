package com.freespirit.controllers;

import com.freespirit.model.Universe;
import javafx.fxml.FXML;

public class MainController {

    @FXML private BoardGameController boardGameController;

    @FXML private void initialize() {
        Universe universe = new Universe(40, 70);
        boardGameController.setUniverse(universe);
    }

}