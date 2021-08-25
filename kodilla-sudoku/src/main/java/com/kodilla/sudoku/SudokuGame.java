package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SudokuGame {

    private final SudokuBoard sudokuBoard = new SudokuBoard();
    private SudokuBoard clonedBoard = null;
    private BackTrack backTrack;
    private List<Integer> ints = new ArrayList<>();

    public void play(){
        try{
            clonedBoard = sudokuBoard.deepCopy();
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }
        System.out.println(sudokuBoard);
        sudokuBoard.runAlgorithm(backTrack);
        System.out.println(sudokuBoard);
//        askCoordinates();
        sudokuBoard.runAlgorithm(backTrack);
        System.out.println(sudokuBoard);
        System.out.println("############");
//        askCoordinates();
        sudokuBoard.runAlgorithm(backTrack);
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
            sudokuBoard.runAlgorithm(backTrack);
        else {
            x = Character.getNumericValue(sudoku.charAt(0));
            y = Character.getNumericValue(sudoku.charAt(2));
            val = Character.getNumericValue(sudoku.charAt(4));
            sudokuBoard.setElement(x-1,y-1,val);
            backTrack = new BackTrack(clonedBoard,x,y,val);
            sudokuBoard.setBackTracks(backTrack);
        }
    }

}
