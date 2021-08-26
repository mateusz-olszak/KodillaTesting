package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private List<SudokuRow> row = new ArrayList<>();

    public SudokuBoard() {
        for (int i=0; i<9; i++){
            row.add(new SudokuRow());
        }
//        generateRandomNumbers();
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
        setElement(7,2,2);
        setElement(8,2,7);
        setElement(8,4,4);
        setElement(8,6,2);
        setElement(8,8,3);
    }
    public List<SudokuRow> getRow() {
        return row;
    }

    private void generateRandomNumbers(){
        Random random = new Random();
        for (int i=0; i<40; i++) {
            setElement(random.nextInt(9),random.nextInt(9),random.nextInt(9)+1);
        }
    }

    private boolean checkElementRow(int x, int value){
        boolean isRow = row.get(x).getElements().stream().anyMatch(e -> e.getValue() == value);
        if (isRow)
            row.get(x).getElements().forEach(e -> e.getPossibleFields().remove(Integer.valueOf(value)));

        return isRow;
    }

    private boolean checkElementCol(int y, int value){
        boolean isCol = row.stream().anyMatch(e -> e.getElements().get(y).getValue() == value);
        if (isCol)
            row.forEach(e -> e.getElements().get(y).getPossibleFields().remove(Integer.valueOf(value)));

        return isCol;
    }

    private boolean checkElementBox(int row, int col, int value){
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow+3; i++)
            for (int j = boxCol; j < boxCol+3; j++)
                if (this.row.get(i).getElements().get(j).getValue() == value) {
                    this.row.get(i).getElements().get(j).getPossibleFields().remove(Integer.valueOf(value));
                    return true;
                }
        return false;
    }

    public boolean isPlaceValid(int x, int y, int val){
        return !checkElementRow(x,val) && !checkElementCol(y,val) && !checkElementBox(x,y,val);
    }

    public void setElement(int x, int y, int val){
        if (isPlaceValid(x,y,val))
            row.get(x).getElements().get(y).setElement(val);
    }

    public boolean runAlgorithm() {
        for (int x=0; x < 9; x++){
            for (int y=0; y < 9; y++){
                if (row.get(x).getElements().get(y).getValue() == SudokuElement.EMPTY){
                    for (int i=1; i <= 9; i++){
                        if (isPlaceValid(x,y,i)){
                            row.get(x).getElements().get(y).setElement(i);

                            if (runAlgorithm()) return true;
                            else row.get(x).getElements().get(y).setElement(SudokuElement.EMPTY);
                        }
                    }
                    return false;
                }
            }
        }

        return true;
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