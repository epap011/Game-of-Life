package com.freespirit.model;

public class DeadCellState implements CellState {

    @Override
    public CellState resurrect() {
        return new AliveCellState();
    }

    @Override
    public CellState die() {
        return this;
    }
}
