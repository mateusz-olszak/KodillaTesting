package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    private List<SudokuRow> row = new ArrayList<>();

    public SudokuBoard() {
        for (int i=0; i<9; i++){
            row.add(new SudokuRow());
        }
        setElement(0,0,7);
        setElement(0,2,2);
        setElement(0,4,5);
        setElement(0,6,6);
        setElement(1,5,3);
        setElement(2,0,1);
        setElement(2,5,9);
        setElement(2,6,5);
        setElement(3,0,8);
        setElement(3,7,9);
        setElement(4,1,4);
        setElement(4,2,3);
        setElement(4,6,7);
        setElement(4,7,5);
        setElement(5,1,9);
        setElement(5,8,8);
        setElement(6,2,9);
        setElement(6,3,7);
        setElement(6,8,5);
        setElement(7,3,2);
        setElement(8,2,7);
        setElement(8,4,4);
        setElement(8,6,2);
        setElement(8,8,3);
    }

    public List<SudokuRow> getRow() {
        return row;
    }

    private boolean checkElementRow(int x, int value){
        return row.get(x).getElements().stream().anyMatch(e -> e.getValue() == value);
    }

    private boolean checkElementCol(int y, int value){
        return row.stream().anyMatch(e -> e.getElements().get(y).getValue() == value);
    }

    private boolean checkElementBox(int row, int col, int value){
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow+3; i++)
            for (int j = boxCol; j < boxCol+3; j++)
                if (this.row.get(i).getElements().get(j).getValue() == value)
                    return true;
        return false;
    }

    public boolean isPlaceValid(int x, int y, int val){
        return !checkElementRow(x,val) && !checkElementCol(y,val) && !checkElementBox(x,y,val);
    }

    private void setElement(int x, int y, int val){
        if (isPlaceValid(x,y,val))
            row.get(x).getElements().get(y).putElement(val);
    }

    @Override
    public String toString() {
        String result = "";
        System.out.println("  123 456 789");
        for (int i=0; i<row.size();i++){
            if (i != 0 && i % 3 ==0)
                result += "  ___________\n";
            result += i+1 + row.get(i).toString().replaceAll(",","");
        }
        return result + "\n";
    }
}