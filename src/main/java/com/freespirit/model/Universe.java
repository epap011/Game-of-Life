package com.freespirit.model;

public class Universe {

    private Grid grid;
    private int generation;

    public Universe(int rows, int cols) {
        grid = new Grid(rows, cols);
        generation = 0;
    }

    public void computeNextGeneration() {
        Grid nextGenGrid = new Grid(grid); //copy constructor

        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                if (grid.getCells().get(i).get(j).getState() instanceof AliveCellState) {
                    if (grid.getCells().get(i).get(j).getNumberOfAliveNeighbours() < 2) {
                        nextGenGrid.getCells().get(i).get(j).die();
                    } else if (grid.getCells().get(i).get(j).getNumberOfAliveNeighbours() > 3)
                        nextGenGrid.getCells().get(i).get(j).die();
                    else
                        nextGenGrid.getCells().get(i).get(j).survive();
                } else {
                    if (grid.getCells().get(i).get(j).getNumberOfAliveNeighbours() == 3)
                        nextGenGrid.getCells().get(i).get(j).resurrect();
                }
            }
        }
        grid = nextGenGrid;
        generation++;
    }

    public void printCurrentGeneration() {
        System.out.println("Generation " + generation);
        grid.printGrid();
    }

    public void dieAt(int row, int col) {
        grid.getCells().get(row).get(col).die();
    }
    public void resurrectAt(int row, int col) {
        grid.getCells().get(row).get(col).resurrect();
    }

    public boolean isCellAliveAt(int row, int col) {
        return grid.getCells().get(row).get(col).getState() instanceof AliveCellState;
    }

    public int getGeneration() {
        return generation;
    }

    public Grid getGrid() { return grid; }
}