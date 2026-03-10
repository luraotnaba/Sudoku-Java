package com.project.sudoku.board;

import java.util.Random;

public class EasyBoard extends SudokuBoard {

    private final Random random = new Random();

    int[][] solvedBoard;

    @Override
    public void generateBoard() {
        this.fillBoard();
        solvedBoard = copyBoard(board);
        this.removeNumbers(40);
    }

    public int[][] getSolvedBoard() {
        return copyBoard(solvedBoard);
    }

    private int[][] copyBoard(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }


    private int[] getRandomNumbers() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for(int i = 0; i < numbers.length; ++i) {
            int j = this.random.nextInt(9);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    private boolean fillBoard() {
        MoveValidator validator = new MoveValidator();

        for(int row = 0; row < SudokuBoard.GRID_SIZE; row++) {
            for(int col = 0; col < SudokuBoard.GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    int[] numbers = this.getRandomNumbers();

                    for(int num : numbers) {
                        if (validator.isSafe(this.board, row, col, num)) {
                            this.board[row][col] = num;

                            if (this.fillBoard()) return true;
                            this.board[row][col] = 0;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private void removeNumbers(int zeroes) {
        int count = 0;

        while(count < zeroes) {
            int row = this.random.nextInt(9);
            int col = this.random.nextInt(9);
            if (this.board[row][col] != 0) {
                this.board[row][col] = 0;
                ++count;
            }
        }

    }
}