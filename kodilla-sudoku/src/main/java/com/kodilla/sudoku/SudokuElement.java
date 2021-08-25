package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SudokuElement {

    public static final int EMPTY = -1;
    private List<Integer> possibleFields = new ArrayList<>();
    private int value;

    public SudokuElement(int value) {
        this.value = value;
        possibleFields.add(1);
        possibleFields.add(2);
        possibleFields.add(3);
        possibleFields.add(4);
        possibleFields.add(5);
        possibleFields.add(6);
        possibleFields.add(7);
        possibleFields.add(8);
        possibleFields.add(9);
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