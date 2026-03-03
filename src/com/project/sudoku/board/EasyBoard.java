package com.project.sudoku.board;

import java.util.Random;

public class EasyBoard extends SudokuBoard {
    Random random = new Random();

    public void generateBoard() {
        this.fillBoard();
        this.removeNumbers(40);
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
        for(int row = 0; row < 9; ++row) {
            for(int col = 0; col < 9; ++col) {
                if (this.board[row][col] == 0) {
                    int[] numbers = this.getRandomNumbers();

                    for(int num : numbers) {
                        if (MoveValidator.isValidMove(this.board, row, col, num)) {
                            this.board[row][col] = num;
                            if (this.fillBoard()) {
                                return true;
                            }

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