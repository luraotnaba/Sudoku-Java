package com.project.sudoku.solver;

public interface Solver {
    public boolean solve(int[][] board);
    public boolean isSolvable(int[][] board);
}
