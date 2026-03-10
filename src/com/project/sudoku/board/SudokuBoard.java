package com.project.sudoku.board;

public abstract class SudokuBoard {

    final static int GRID_SIZE = 9;
    protected int[][] board;

    public SudokuBoard(){
        board = new int[GRID_SIZE][GRID_SIZE];
    }

    public abstract void generateBoard();

    public void display() {

        System.out.println("    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");

        for (int row = 0; row < GRID_SIZE; row++) {

            System.out.print((row + 1) + " | ");

            for (int col = 0; col < GRID_SIZE; col++) {

                if (board[row][col] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col] + " ");
                }

                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((row + 1) % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }
        }
    }

    public void displaySolved(int[][] solvedBoard) {
        System.out.println("    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");

        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print((row + 1) + " | ");

            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(solvedBoard[row][col] + " ");

                if ((col + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();

            if ((row + 1) % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }
        }
    }

    public boolean isComplete() {

        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {

                if (board[row][col] == 0) {
                    return false; // found empty cell
                }
            }
        }

        return true;
    }


    public int[][] getBoard() {
        return board;
    }


    public void setNumber(int row, int col, int num) {
        board[row][col] = num;
    }
}
