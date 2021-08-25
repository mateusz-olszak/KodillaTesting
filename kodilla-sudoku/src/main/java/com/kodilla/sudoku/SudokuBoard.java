package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype<SudokuBoard> {

    private List<SudokuRow> row = new ArrayList<>();
    private List<BackTrack> backTracks = new ArrayList<>();

    public SudokuBoard() {
        for (int i=0; i<9; i++){
            row.add(new SudokuRow());
        }
//        generateRandomNumbers();
        setElement(0,0,8);
        setElement(2,0,6);
        setElement(2,1,5);
        setElement(1,2,3);
        setElement(1,3,6);
        setElement(2,1,7);
        setElement(2,4,9);
        setElement(2,6,2);
        setElement(3,1,5);
        setElement(3,5,7);
        setElement(4,4,4);
        setElement(4,5,5);
        setElement(4,6,7);
        setElement(5,3,1);
        setElement(5,7,3);
        setElement(6,2,1);
        setElement(6,7,6);
        setElement(6,8,8);
        setElement(7,2,8);
        setElement(7,3,5);
        setElement(7,7,1);
        setElement(8,1,9);
        setElement(8,6,4);
    }

    public void setBackTracks(BackTrack backTrack) {
        this.backTracks.add(backTrack);
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
        return row.get(x).getElements().stream().anyMatch(e -> e.getValue() == value);
    }

    private boolean checkElementCol(int y, int value){
        row.stream().map(e -> e.getElements().get(y).getPossibleFields().removeIf(n -> n == value));
        return row.stream().anyMatch(e -> e.getElements().get(y).getValue() == value);
    }

    private boolean checkElementBox(int row, int col, int value){
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow+3; i++)
            for (int j = boxCol; j < boxCol+3; j++)
                if (this.row.get(i).getElements().get(j).getValue() == value) {
                    this.row.get(i).getElements().stream().map(e -> e.getPossibleFields().removeIf(n -> n == value));
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

    public boolean runAlgorithm(BackTrack backTrack) {
        for (int x = 0; x < 9; x++){
            for (int y = 0; y < 9; y++){
                if (row.get(x).getElements().get(y).getValue() == SudokuElement.EMPTY){
                    for (int i : row.get(x).getElements().get(y).getPossibleFields()){
//                        if (checkElementRow(x,i)) row.get(x).getElements().get(y).getPossibleFields().remove(i-1);
                        if (isPlaceValid(x,y,i)){
                            row.get(x).getElements().get(y).setElement(i);

                            if (runAlgorithm(backTrack)) return true;
                            row.get(x).getElements().get(y).setElement(SudokuElement.EMPTY);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException{
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.row = new ArrayList<>();
        for (SudokuRow r : row){
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.setElements(new ArrayList<>());
            for (SudokuElement e : r.getElements()){
                clonedRow.getElements().add(e);
            }
            clonedBoard.row.add(clonedRow);
        }
        return clonedBoard;
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