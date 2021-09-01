package com.kodilla.sudoku;

public class SudokuGame {

    private final SudokuBoard sudokuBoard = new SudokuBoard();

    public void play(){
        String solved;
        System.out.println(sudokuBoard);
        if (runAlgorithm()) solved = "Sudoku solved successfully!";
        else solved = "Cannot solve sudoku";
        System.out.println(sudokuBoard);
        System.out.println(solved);
    }

    private boolean runAlgorithm() {
        for (int x=0; x < 9; x++){
            for (int y=0; y < 9; y++){
                if (sudokuBoard.getRow().get(x).getElements().get(y).getValue() == SudokuElement.EMPTY){
                    for (int i=1; i<=9; i++){
                        if (sudokuBoard.isPlaceValid(x,y,i)){
                            sudokuBoard.getRow().get(x).getElements().get(y).putElement(i);

                            if (runAlgorithm()) return true;
                            else sudokuBoard.getRow().get(x).getElements().get(y).putElement(SudokuElement.EMPTY);
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
