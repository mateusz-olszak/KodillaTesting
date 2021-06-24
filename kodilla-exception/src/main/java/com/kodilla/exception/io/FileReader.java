package com.kodilla.exception.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile(String fileName) throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();

        try(Stream<String> files = Files.lines(Path.of(classLoader.getResource(fileName).toURI()))){
            files.forEach(System.out::println);
        }catch(Exception e){
            throw new FileReaderException();
        }finally {
            System.out.println("I'am always here");
        }
    }
}
