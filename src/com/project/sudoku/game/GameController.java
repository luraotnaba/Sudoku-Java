package com.project.sudoku.game;

import com.project.sudoku.board.EasyBoard;
import com.project.sudoku.board.MoveValidator;
import com.project.sudoku.solver.*;

/*
GameController
-controls the full game flow
 */

public class GameController {
    private EasyBoard board;
    private MoveValidator validator;
    private SimpleSolver solver;
    private HintSystem hintSystem;
    private InputHandler inputHandler;
    private Player player;

    public GameController() {
        inputHandler = new InputHandler();

        String name = inputHandler.getPlayerName();
        player = new Player(name);

        board = new EasyBoard();
        board.generateBoard();

        validator = new MoveValidator();
        solver = new SimpleSolver();

        hintSystem = new HintSystem();
    }

    public void startGame() {
        System.out.println("\nWelcome to Sudoku Master, " + player.getName() + "!\n");
        board.display();

        while(!isPuzzleSolved()) {
            int choice = inputHandler.getMenuChoice();

            switch(choice) {
                case 1 :
                    handleMove();
                    break;

                case 2:
                    handleHint();
                    break;

                case 3:
                    handleSolveDebug();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    player.displayStats();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 0-3.");
            }
        }
        // loop exits naturally, puzzle is complete.
        System.out.println("\nCongratulations! You completed the Sudoku!");
        player.displayStats();
    }

    private void handleMove() {
        int row = inputHandler.getRow() - 1;
        int col = inputHandler.getCol() - 1;
        int num = inputHandler.getNumber();

        //check if move is valid
        if(validator.isValidMove(board.getBoard(), board.getSolvedBoard(), row, col, num)) {
            board.setNumber(row, col, num);
            System.out.println("Move accepted!\n");
        } else {
            System.out.println("Invalid Move!\n");
            player.addMistake(); //tracks mistake
        }
        board.display();
    }

    private void handleHint() {
        Hint hint = hintSystem.getHint(board.getBoard(), board.getSolvedBoard());

        if(hint != null) {
            System.out.println("Hint: Place " + hint.getNum() + " at (" + (hint.getRow() + 1)
                + "," + (hint.getCol() + 1) + ")");
            player.useHint(); // tracks hint usage
        } else {
            System.out.println("No hints available or board is complete!");
        }
    }

    //show solved board
    private void handleSolveDebug() {
        System.out.println("");
        board.displaySolved(board.getSolvedBoard());
    }

    private boolean isPuzzleSolved() {
        int[][] current = board.getBoard();
        int[][] solved = board.getSolvedBoard();

        for (int row = 0; row < current.length; row++) {
            for (int col = 0; col < current[row].length; col++) {
                if (current[row][col] != solved[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
