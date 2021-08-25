package com.kodilla.sudoku;

public class BackTrack {

    private SudokuBoard board;
    private int row;
    private int col;
    private int value;

    public BackTrack(SudokuBoard board, int row, int col, int value) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getValue() {
        return value;
    }
}
