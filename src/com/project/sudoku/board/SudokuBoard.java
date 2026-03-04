package com.project.sudoku.board;

public abstract class SudokuBoard {

    final static int GRID_SIZE = 9;
    protected int[][] board;


    public abstract void generateBoard();


    public void display() {
        System.out.println("    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");

        for (int row = 0; row < 9; row++) {

            System.out.print(row + " | ");

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col] + " ");
                }

                // Add vertical separator every 3 columns
                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            // Add horizontal separator every 3 rows
            if ((row + 1) % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }
        }
    }

    public boolean isComplete() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {
                    return false; // found empty cell
                }
            }
        }

        return true; // no empty cells
    }


    public int[][] getBoard() {
        return board;
    }
    public void setNumber(int row, int col, int num) {
        board[row][col] = num;
    }
}
