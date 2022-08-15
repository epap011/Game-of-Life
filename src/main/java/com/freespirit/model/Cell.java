package com.freespirit.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Properties;

public class Cell {
    PropertyChangeSupport propertyChangeSupport;

    private CellState state;
    private ArrayList<Cell> neighbours;

    private int aliveNeighbours;

    public Cell() {;
        propertyChangeSupport = new PropertyChangeSupport(this);
        neighbours      = new ArrayList<>(8);
        state           = new DeadCellState();
        aliveNeighbours = 0;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() { return state; }

    public void die() {
        CellState oldState = state;
        state = state.die();
        updateNeighbours();
        propertyChangeSupport.firePropertyChange("cellState", oldState, state);
    }

    public void born() {
        CellState oldState = state;
        state = state.born();
        updateNeighbours();
        propertyChangeSupport.firePropertyChange("cellState", oldState, state);
    }

    public void survive() {
        state = state.survive();
    }

    public void setNeighbours(ArrayList<Cell> neighbours) { this.neighbours = neighbours; }

    public void setAliveNeighbours(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;
    }

    public int getNumberOfAliveNeighbours() {
        return aliveNeighbours;
    }

    private void updateNeighbours() {
        int existence;

        if(state instanceof AliveCellState) {
            existence = 1;
        } else {
            existence = -1;
        }

        for (Cell neighbour : neighbours) {
            neighbour.setAliveNeighbours(neighbour.getNumberOfAliveNeighbours() + existence);
        }
    }
}
