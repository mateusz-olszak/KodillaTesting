package com.kodilla.sudoku;

import java.util.Objects;

public class SudokuElement {

    public static final int EMPTY = -1;
    private int value;

    public SudokuElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void putElement(int value){
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}