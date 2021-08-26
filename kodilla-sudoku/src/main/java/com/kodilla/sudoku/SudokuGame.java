package com.kodilla.sudoku;

import java.util.Locale;
import java.util.Scanner;

public class SudokuGame {

    private final SudokuBoard sudokuBoard = new SudokuBoard();

    public void play(){
        System.out.println(sudokuBoard);
        sudokuBoard.runAlgorithm();
        System.out.println(sudokuBoard);
        System.out.println("############");


        int counter = 0;
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                counter += sudokuBoard.getRow().get(i).getElements().get(j).getPossibleFields().size();
            }
        }
        System.out.println(counter);

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
