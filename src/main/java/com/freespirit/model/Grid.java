package com.freespirit.model;

import java.util.ArrayList;

public class Grid {

    private ArrayList<ArrayList<Cell>> cells;
    private int rows;
    private int cols;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        initializeCells();
        assignNeighboursToCells();
    }

    public Grid(Grid grid) {
        this(grid.getRows(), grid.getCols());

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cells.get(i).get(j).setState(grid.getCells().get(i).get(j).getState());
                this.cells.get(i).get(j).setAliveNeighbours(grid.getCells().get(i).get(j).getNumberOfAliveNeighbours());
            }
        }
    }

    public void printGrid() {
        for (ArrayList<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getState() instanceof AliveCellState)
                    System.out.print("0");
                else
                    System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void clearGrid() {
        for (ArrayList<Cell> row : cells) {
            for (Cell cell : row) {
                cell.die();
            }
        }
    }

    public int getRows() { return rows; }

    public int getCols() { return cols; }

    public ArrayList<ArrayList<Cell>> getCells() { return cells; }
    private void initializeCells() {
        cells = new ArrayList<>(rows);

        for (int i = 0; i < rows; i++) {
            cells.add(new ArrayList<>(cols));
        }

        for (ArrayList<Cell> row : cells) {
            for (int i = 0; i < cols; i++) {
                row.add(i, new Cell());
            }
        }
    }
    private void assignNeighboursToCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ArrayList<Cell> neighbours = new ArrayList<>(8);
                if (i == 0) {
                    if (j == 0) {
                        neighbours.add(cells.get(0).get(1));
                        neighbours.add(cells.get(1).get(0));
                        neighbours.add(cells.get(1).get(1));
                    } else if (j == cols - 1) {
                        neighbours.add(cells.get(0).get(cols - 2));
                        neighbours.add(cells.get(1).get(cols - 1));
                        neighbours.add(cells.get(1).get(cols - 2));
                    } else {
                        neighbours.add(cells.get(0).get(j - 1));
                        neighbours.add(cells.get(0).get(j + 1));
                        neighbours.add(cells.get(1).get(j - 1));
                        neighbours.add(cells.get(1).get(j));
                        neighbours.add(cells.get(1).get(j + 1));
                    }

                } else if (i == rows - 1) {
                    if (j == 0) {
                        neighbours.add(cells.get(rows - 1).get(1));
                        neighbours.add(cells.get(rows - 2).get(0));
                        neighbours.add(cells.get(rows - 2).get(1));
                    } else if (j == cols - 1) {
                        neighbours.add(cells.get(rows - 1).get(cols - 2));
                        neighbours.add(cells.get(rows - 2).get(cols - 1));
                        neighbours.add(cells.get(rows - 2).get(cols - 2));
                    } else {
                        neighbours.add(cells.get(rows - 1).get(j - 1));
                        neighbours.add(cells.get(rows - 1).get(j + 1));
                        neighbours.add(cells.get(rows - 2).get(j - 1));
                        neighbours.add(cells.get(rows - 2).get(j));
                        neighbours.add(cells.get(rows - 2).get(j + 1));
                    }
                } else {
                    if (j == 0) {
                        neighbours.add(cells.get(i).get(1));
                        neighbours.add(cells.get(i - 1).get(0));
                        neighbours.add(cells.get(i - 1).get(1));
                        neighbours.add(cells.get(i + 1).get(0));
                        neighbours.add(cells.get(i + 1).get(1));
                    } else if (j == cols - 1) {
                        neighbours.add(cells.get(i).get(cols - 1 - 1));
                        neighbours.add(cells.get(i - 1).get(cols - 1));
                        neighbours.add(cells.get(i - 1).get(cols - 1 - 1));
                        neighbours.add(cells.get(i + 1).get(cols - 1));
                        neighbours.add(cells.get(i + 1).get(cols - 1 - 1));
                    } else {
                        neighbours.add(cells.get(i).get(j + 1));
                        neighbours.add(cells.get(i).get(j - 1));
                        neighbours.add(cells.get(i - 1).get(j));
                        neighbours.add(cells.get(i - 1).get(j - 1));
                        neighbours.add(cells.get(i - 1).get(j + 1));
                        neighbours.add(cells.get(i + 1).get(j));
                        neighbours.add(cells.get(i + 1).get(j - 1));
                        neighbours.add(cells.get(i + 1).get(j + 1));
                    }
                }
                cells.get(i).get(j).setNeighbours(neighbours);
            }
        }
    }
}