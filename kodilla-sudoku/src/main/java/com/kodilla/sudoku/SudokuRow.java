package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SudokuRow {

    private List<SudokuElement> elements = new ArrayList<>();

    public SudokuRow() {
        for (int i=0; i<9; i++){
            elements.add(new SudokuElement(SudokuElement.EMPTY));
        }
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i=0; i<elements.size();i++){
            if (i%3==0)
                result += "|";
            result += elements.get(i).toString().replaceAll(",","");
        }

        return result + "|\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuRow sudokuRow = (SudokuRow) o;
        return Objects.equals(elements, sudokuRow.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}