package com.project.sudoku.board;

public abstract class SudokuBoard {
    /*
     * board
     * 2D array representing the Sudoku grid.
     * Values range from 1–9.
     * 0 means empty cell.
     */
    protected int[][] board = new int[9][9];


    /*
     * generateBoard()
     * Abstract method.
     * Subclasses must implement how the puzzle is created.
     */
    public abstract void generateBoard();


    /*
     * display()
     * Prints the board in a formatted layout.
     */
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


    /*
     * isComplete()
     * Returns true if no cell contains 0.
     */
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


    /*
     * getBoard()
     * Returns the board array.
     */
    public int[][] getBoard() {
        return board;
    }


    /*
     * setNumber(row, col, num)
     * Sets a value in a cell.
     * No validation here.
     */
    public void setNumber(int row, int col, int num) {
        board[row][col] = num;
    }
}
