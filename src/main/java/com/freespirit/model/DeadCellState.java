package com.freespirit.model;

public class DeadCellState implements CellState {

    @Override
    public CellState born() {
        return new AliveCellState();
    }

    @Override
    public CellState die() {
        return null;
    }

    @Override
    public CellState survive() {
        return null;
    }
}
