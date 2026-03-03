package com.project.sudoku.solver;

import com.project.sudoku.*;

public class SimpleSolver implements Solver{

    public boolean numberInRow(int[][] board, int row, int num){
        for(int j = 0;j < board.length;j++){
            if(board[row][j] == num) return true;
        }
        return false;
    }

    public boolean numberInColumn(int[][] board, int col, int num){
        for(int i = 0;i < board.length;i++) {
            if (board[i][col] == num) return true;
        }
        return false;
    }

    public boolean numberInBox(int[][] board, int row, int col, int num){
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for(int i = localRow;i < localRow + 3;i++){
            for(int j = localCol;j < localCol + 3;j++){
                if(board[i][j] == num) return true;
            }
        }
        return false;
    }

    public boolean numberIsValid(int[][] board, int row, int col, int num){
        return !numberInRow(board, row, num) &&
                !numberInColumn(board, col, num) &&
                !numberInBox(board, row, col, num);
    }

    public boolean solve(int[][] board){
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board.length;j++){
                if(board[i][j] == 0){
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
