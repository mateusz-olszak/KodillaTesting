package com.kodilla.sudoku;

import java.util.List;
import java.util.Objects;

public class SudokuElement {

    public static final int EMPTY = -1;
    private List<Integer> possibleFields = List.of(1,2,3,4,5,6,7,8,9);
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleFields() {
        return possibleFields;
    }

    public int getValue() {
        return value;
    }

    public void setElement(int value){
        if (this.value == EMPTY)
            this.value = value;
    }

    @Override
    public String toString() {
        return (value == -1 ? "-" : String.valueOf(value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuElement that = (SudokuElement) o;
        return value == that.value && Objects.equals(possibleFields, that.possibleFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(possibleFields, value);
    }
}