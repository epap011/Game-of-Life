package com.freespirit.controllers;

import com.freespirit.model.AliveCellState;
import com.freespirit.model.Universe;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BoardGameController {

    Universe universe;
    private final int GRID_ROW_SIZE = 40;
    private final int GRID_COL_SIZE = 70;
    private final int RECT_SIZE     = 10;
    @FXML private GridPane grid;
    private Rectangle[][] rectangles;

    @FXML private void initialize() {
        initializeGridRectangles();
    }

    private void initializeGridRectangles() {
        rectangles = new Rectangle[GRID_ROW_SIZE][GRID_COL_SIZE];

        for (int i = 0; i < GRID_ROW_SIZE; i++) {
            for (int j = 0; j < GRID_COL_SIZE; j++) {
                Rectangle rect = new Rectangle();
                customizeRectangle(rect);
                rectangles[i][j] = rect;
                grid.add(rect, j, i);
            }
        }
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
        initializeChangeListeners();
    }

    private void initializeChangeListeners() {
        for (int i = 0; i < GRID_ROW_SIZE; i++) {
            for (int j = 0; j < GRID_COL_SIZE; j++) {
                int finalI = i;
                int finalJ = j;
                universe.getGrid().getCells().get(i).get(j).addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (evt.getNewValue() instanceof AliveCellState) {
                            System.out.println("Cell["+finalI+","+finalJ+"] is now Alive");
                            rectangles[finalI][finalJ].setFill(Color.BLACK);
                        } else {
                            System.out.println("Cell["+finalI+","+finalJ+"] is now Dead");
                            rectangles[finalI][finalJ].setFill(Color.WHITE);
                        }
                    }
                });
            }
        }
    }

    private void customizeRectangle(Rectangle rect) {
        rect.setHeight(RECT_SIZE);
        rect.setWidth(RECT_SIZE);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.web("#F6F6F6"));
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStrokeWidth(0.5);
        rect.setOnMouseClicked(this::mouseClickedEvent);
    }

    private void mouseClickedEvent(MouseEvent e) {
        Rectangle eventSourceRectangle = (Rectangle) e.getSource();
        int eventSourceRow = GridPane.getRowIndex(eventSourceRectangle);
        int eventSourceCol = GridPane.getColumnIndex(eventSourceRectangle);

        if(universe.isCellAliveAt(eventSourceRow, eventSourceCol)) {
            universe.dieAt(eventSourceRow, eventSourceCol);
        } else {
            universe.bornAt(eventSourceRow, eventSourceCol);
        }
    }

    public void computeNextGeneration() {
        universe.computeNextGeneration();
    }
}