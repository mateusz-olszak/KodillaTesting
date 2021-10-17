package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeworkTestSuite {

    @Test
    void testNotifyMentors() {
        // Given
        Mentor hubert = new Mentor("Hubert");
        Mentor arek = new Mentor("Arek");
        Mentor marek = new Mentor("Marek");
        Student krystian = new Student("Krystian");
        Student mateusz = new Student("Mateusz");
        Student janek = new Student("Janek");
        Task task1 = new Task("Stream API task");
        Task task2 = new Task("OOP task");
        Task task3 = new Task("Design Patterns task");
        Task task4 = new Task("Hibernate task");
        Task task5 = new Task("REST API task");
        Task task6 = new Task("Database task");
        krystian.register(arek);
        mateusz.register(hubert);
        janek.register(marek);
        // When
        krystian.addTask(task1);
        krystian.addTask(task2);
        mateusz.addTask(task3);
        mateusz.addTask(task4);
        janek.addTask(task5);
        janek.addTask(task6);
        // Then
        assertEquals(2, hubert.getCountTasks());
        assertEquals(2, arek.getCountTasks());
        assertEquals(2, marek.getCountTasks());
        assertEquals(0, mateusz.getTasks().size());
    }

}
