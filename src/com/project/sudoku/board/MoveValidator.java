package com.project.sudoku.board;

public class MoveValidator {
    public boolean isValidMove(int[][]board, int row, int col, int num){
        int GRIZ_SIZE = board.length;
        //checking the row
        for(int j = 0;j < GRIZ_SIZE;j++){
            if(board[row][j] == num) return false;
        }

        //checking the column
        for(int i = 0;i < GRIZ_SIZE;i++){
            if(board[i][col] == num) return false;
        }

        //checking the box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow;i < startRow + 3;i++){
            for(int j = startCol;j < startCol + 3;j++){
                if(board[i][j] == num) return false;
            }
        }
        return true;
    }
}
