package com.project.sudoku.game;

import java.util.*;

public class InputHandler {
    Scanner s = new Scanner(System.in);

    public String getPlayerName() {
        System.out.print("Enter player name: ");
        return s.nextLine();
    }

    public int getMenuChoice() {
        System.out.println("Options:");
        System.out.println("1 - Enter a move");
        System.out.println("2 - Get a hint");
        System.out.println("3 - Show solved board");
        System.out.println("0 - Exit");
        System.out.print("Choice: ");
        return s.nextInt();
    }

    public int getRow() {
        System.out.print("Enter row (1-9): ");
        return s.nextInt();
    }

    public int getCol() {
        System.out.print("Enter column (1-9): ");
        return s.nextInt();
    }

    public int getNumber() {
        System.out.print("Enter number (1-9): ");
        return s.nextInt();
    }
}
