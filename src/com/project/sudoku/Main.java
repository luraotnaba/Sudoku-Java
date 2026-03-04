package com.project.sudoku;

import com.project.sudoku.board.EasyBoard;
import com.project.sudoku.board.MoveValidator;
import com.project.sudoku.solver.Hint;
import com.project.sudoku.solver.HintSystem;
import com.project.sudoku.solver.SimpleSolver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        EasyBoard board = new EasyBoard();
        board.generateBoard();

        System.out.println("Welcome to Sudoku Master!\n");
        board.display();

        // Step 2: Create validator, solver, and hint system
        MoveValidator validator = new MoveValidator();
        SimpleSolver solver = new SimpleSolver();
        HintSystem hintSystem = new HintSystem(solver);

        Scanner sc = new Scanner(System.in);

        // Main game loop
        while (!board.isComplete()) {
            System.out.println("\nOptions:");
            System.out.println("1 - Enter a move");
            System.out.println("2 - Get a hint");
            System.out.println("3 - Show solved board (for debug)");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter row (1-9): ");
                int row = sc.nextInt() - 1;
                System.out.print("Enter column (1-9): ");
                int col = sc.nextInt() - 1;
                System.out.print("Enter number (1-9): ");
                int num = sc.nextInt();

                if (validator.isValidMove(board.getBoard(), row, col, num)) {
                    board.setNumber(row, col, num);
                    System.out.println("Move accepted!");
                } else {
                    System.out.println("Invalid move!");
                }

                board.display();

            } else if (choice == 2) {
                Hint hint = hintSystem.getHint(board.getBoard());
                if (hint != null) {
                    System.out.println("Hint: Place " + hint.getNum() +
                            " at (" + (hint.getRow() + 1) + "," + (hint.getCol() + 1) + ")");
                } else {
                    System.out.println("No hints available or board is already complete!");
                }

            } else if (choice == 3) {
                // Show solved board for debug
                solver.solve(board.getBoard());
                board.display();

            } else if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Please enter 0-3.");
            }
        }

        sc.close();

        if (board.isComplete()) {
            System.out.println("Congratulations! You completed the Sudoku!");
        }
    }
}
