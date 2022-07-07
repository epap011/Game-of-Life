package com.freespirit.model;

public class AliveCellState implements CellState {

    @Override
    public CellState resurrect() {
        return this;
    }

    @Override
    public CellState die() {
        return new DeadCellState();
    }
}
