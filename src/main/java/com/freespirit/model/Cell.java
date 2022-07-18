package com.freespirit.model;

import java.util.ArrayList;

public class Cell {

    private CellState state;
    private ArrayList<Cell> neighbours;

    private int aliveNeighbours;

    public Cell() {
        neighbours      = new ArrayList<>(8);
        state           = new DeadCellState();
        aliveNeighbours = 0;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public CellState getState() { return state; }

    public void die() {
        state = state.die();
        updateNeighbours();
    }

    public void born() {
        state = state.born();
        updateNeighbours();
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
