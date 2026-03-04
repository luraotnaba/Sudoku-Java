package com.project.sudoku.solver;

public class Hint {
    private final int row, col, num;

    public Hint(int row, int col, int num){
        this.row = row;
        this.col = col;
        this.num = num;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getNum() { return num; }
}
