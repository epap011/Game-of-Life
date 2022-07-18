package com.freespirit.model;

public interface CellState {

    CellState born();
    CellState die();

    CellState survive();
}
