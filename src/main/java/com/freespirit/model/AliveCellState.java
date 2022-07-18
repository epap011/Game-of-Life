package com.freespirit.model;

public class AliveCellState implements CellState {

    @Override
    public CellState born() {
        return null;
    }

    @Override
    public CellState die() {
        return new DeadCellState();
    }

    @Override
    public CellState survive() {
        return this;
    }
}
