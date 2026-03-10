package com.project.sudoku.solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HintSystem {
    private final Random rand = new Random();

    public HintSystem(SimpleSolver solver){
        this.solver = solver;
    }

    public Hint getHint(int[][] board){
        if(!solver.isSolvable(board)) return null;

        int[][] copy = new int[board.length][board.length];
        for(int i = 0;i < copy.length;i++){
            for(int j = 0;j < copy.length;j++){
                copy[i][j] = board[i][j];
            }
        }
        solver.solve(copy);

        List<int[]> emptyCells = collectEmptyCells(board);
        if(emptyCells.isEmpty()) return null;
        Random rand = new Random();
        int index = rand.nextInt(emptyCells.size());
        int pos[] = emptyCells.get(index);
        int hintRow = pos[0];
        int hintCol = pos[1];
        int hintNum = copy[hintRow][hintCol];

        return new Hint(hintRow, hintCol, hintNum);

    }

    private List<int[]> collectEmptyCells(int[][] board){
        List<int[]> emptyCells = new ArrayList<>();

        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[i].length;j++){
                if(board[i][j] == 0) emptyCells.add(new int[]{i, j});
            }
        }
        return emptyCells;
    }

}
