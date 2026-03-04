package com.project.sudoku.solver;

// Solver interface defines the contract for any Sudoku solving class
public interface Solver {

    // Attempt to solve the given Sudoku board
    // Returns true if the board is solved successfully, false otherwise
    public boolean solve(int[][] board);

    // Check if the given Sudoku board is solvable without modifying the original board
    // Returns true if a solution exists, false otherwise
    public boolean isSolvable(int[][] board);
}
