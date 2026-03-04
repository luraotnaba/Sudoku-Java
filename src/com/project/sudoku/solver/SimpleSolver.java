package com.project.sudoku.solver;

import com.project.sudoku.*;

public class SimpleSolver implements Solver{

    // Check if a number exists in the specified row
    public boolean numberInRow(int[][] board, int row, int num){
        for(int j = 0;j < board.length;j++){
            if(board[row][j] == num) return true; // Number found in row
        }
        return false; // Number not found
    }

    // Check if a number exists in the specified column
    public boolean numberInColumn(int[][] board, int col, int num){
        for(int i = 0;i < board.length;i++) {
            if (board[i][col] == num) return true; // Number found in column
        }
        return false; // Number not found
    }

    // Check if a number exists in the 3x3 box containing the specified cell
    public boolean numberInBox(int[][] board, int row, int col, int num){
        int localRow = row - row % 3; // Top-left row of the box
        int localCol = col - col % 3; // Top-left column of the box

        for(int i = localRow;i < localRow + 3;i++){
            for(int j = localCol;j < localCol + 3;j++){
                if(board[i][j] == num) return true; // Number found in box
            }
        }
        return false; // Number not found
    }

    // Check if placing a number at a specific cell is valid
    public boolean numberIsValid(int[][] board, int row, int col, int num){
        return !numberInRow(board, row, num) &&
                !numberInColumn(board, col, num) &&
                !numberInBox(board, row, col, num);
    }

    // Solve the Sudoku board using backtracking
    public boolean solve(int[][] board){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board.length;j++){
                if(board[i][j] == 0){ // Empty cell found
                    for(int k = 1; k <= 9; k++){
                        if(numberIsValid(board, i, j, k)){
                            board[i][j] = k;
                            if(solve(board)) return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    // Check if the board is solvable without modifying the original board
    public boolean isSolvable(int[][] board){
        int[][] copy = new int[board.length][board.length];

        for(int i = 0;i < copy.length;i++){
            for(int j = 0;j < copy.length;j++){
                copy[i][j] = board[i][j];
            }
        }

        return solve(copy);
    }
}
