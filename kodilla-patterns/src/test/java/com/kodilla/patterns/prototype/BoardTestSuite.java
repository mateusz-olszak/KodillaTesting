package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTestSuite {

    @Test
    void testToString(){
        // create toDoTaskList
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do task " + n)));

        // create inProgressList
        TaskList inProgressList = new TaskList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> inProgressList.getTasks().add(new Task("In Progress Tasks " + n)));

        // create doneList
        TaskList doneList = new TaskList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> doneList.getTasks().add(new Task("Done Tasks " + n)));

        // create board
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(inProgressList);
        board.getLists().add(doneList);

        // shallow copy
        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        // deep copy
        Board deepClonedCopy = null;
        try {
            deepClonedCopy = board.deepCopy();
            deepClonedCopy.setName("Project number 3");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        board.getLists().remove(listToDo);

        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedCopy);

        assertEquals(2, board.getLists().size());
        assertEquals(2, clonedBoard.getLists().size());
        assertEquals(3, deepClonedCopy.getLists().size());
        assertEquals(clonedBoard.getLists().size(), board.getLists().size());
        assertNotEquals(deepClonedCopy.getLists(), board.getLists().size());
    }

}
