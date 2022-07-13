package com.freespirit.model;

public interface CellState {

    CellState resurrect();
    CellState die();

    CellState survive();
}
