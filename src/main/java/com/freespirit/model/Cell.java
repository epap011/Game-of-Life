package com.freespirit.model;

import java.util.ArrayList;

public class Cell {

    private CellState state;
    private ArrayList<Cell> neighbours;
    public Cell() {
        neighbours = new ArrayList<>(8);
        state      = new DeadCellState();
    }

    public CellState getState() { return state; }

    public void changeState(CellState newState) { state = newState; }

    public ArrayList<Cell> getNeighbours() { return neighbours; }

    public void setNeighbours(ArrayList<Cell> neighbours) { this.neighbours = neighbours; }

    public int getNumberOfNeighbours() { return neighbours.size(); }
}
