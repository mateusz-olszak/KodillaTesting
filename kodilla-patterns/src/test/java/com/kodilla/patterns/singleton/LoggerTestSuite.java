package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;
    private static ArrayDeque<String> queue;

    @BeforeAll
    public static void prepareData(){
        logger = Logger.INSTANCE;
        queue = new ArrayDeque<>();
    }

    @AfterAll
    public static void showingData(){
        prepareLogs();
        queue.stream().map(e -> "Log: [" + queue.pollFirst() + "]").forEach(System.out::println);
    }

    @Test
    void testAddLog(){
        logger.log("testLog");

        String log = logger.getLastLog();

        assertEquals("testLog",log);
    }


    private static void prepareLogs(){
        logger.log("opening file");
        queue.offer(logger.getLastLog());

        logger.log("file's settings changed");
        queue.offer(logger.getLastLog());

        logger.log("file' settings saved");
        queue.offer(logger.getLastLog());

        logger.log("closing file");
        queue.offer(logger.getLastLog());
    }

}
