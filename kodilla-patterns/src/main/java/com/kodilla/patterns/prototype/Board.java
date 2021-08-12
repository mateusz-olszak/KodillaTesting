package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Board extends Prototype<Board>{

    private String name;
    private Set<TaskList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public Set<TaskList> getLists() {
        return lists;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TaskList list : lists){
            TaskList clonedList = new TaskList(list.getName());
            for (Task task : list.getTasks()){
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(clonedList);
        }

        return clonedBoard;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TaskList list : lists){
            s = s + list.toString() + "\n";
        }

        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name) && Objects.equals(lists, board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}
