package com.kodilla.sudoku;

import java.util.Locale;
import java.util.Scanner;

public class SudokuGame {

    private final SudokuBoard sudokuBoard = new SudokuBoard();


    public void play(){
        SudokuBoard clonedBoard = null;
        try{
            clonedBoard = sudokuBoard.deepCopy();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        System.out.println(sudokuBoard);
        askCoordinates();
        System.out.println(sudokuBoard);
        System.out.println("############");
        askCoordinates();
        System.out.println(sudokuBoard);
        System.out.println("############");
        askCoordinates();
        System.out.println(sudokuBoard);
        System.out.println("############");
    }

    private void askCoordinates(){
        Scanner scanner = new Scanner(System.in);
        String SUDOKU = "SUDOKU";
        System.out.print("Enter coordinates(row,col,val): ");
        String sudoku; int x,y,val;
        sudoku = scanner.nextLine().toUpperCase(Locale.ROOT);
        if (sudoku.equals(SUDOKU))
            sudokuBoard.runAlgorithm();
        else {
            x = Character.getNumericValue(sudoku.charAt(0));
            y = Character.getNumericValue(sudoku.charAt(2));
            val = Character.getNumericValue(sudoku.charAt(4));
            sudokuBoard.setElement(x-1,y-1,val);
        }
    }

}
