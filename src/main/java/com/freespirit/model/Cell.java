package com.freespirit.model;

import java.util.ArrayList;

public class Cell {

    //private State state;
    private ArrayList<Cell> neighbours;
    public Cell() {
        neighbours = new ArrayList<>(8);
        //state      = new State();
    }

    //public State getState() { return state; }

    //public void changeState(State newState) { state = newState; }

    public ArrayList<Cell> getNeighbours() { return neighbours; }

    public void setNeighbours(ArrayList<Cell> neighbours) { this.neighbours = neighbours; }

    public int getNumberOfNeighbours() { return neighbours.size(); }
}
