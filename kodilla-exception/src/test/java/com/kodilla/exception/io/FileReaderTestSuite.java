package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    public void testReadFileWhenNotExists(){
        FileReader fileReader = new FileReader();
        String fileName = "no-such-file.txt";

        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName)),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }

}
