package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        Library library = new Library("Thriller Books");
        IntStream.iterate(1, n -> n+1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("book" + n,"author" + n,LocalDate.now())));

        // shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Biography Books");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        // deep copy
        Library deepClonedCopy = null;
        try {
            deepClonedCopy = library.deepCopy();
            deepClonedCopy.setName("Drama Books");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        // print shallow copy before change
        System.out.println(library);
        System.out.println("----------");
        System.out.println(clonedLibrary);

        library.getBooks().stream().findFirst().map(e -> library.getBooks().remove(e));

        // print shallow copy after change
        System.out.println("----------");
        System.out.println(library);
        System.out.println("----------");
        System.out.println(clonedLibrary);


        // print deep copy
        System.out.println("######################### deep copy");
        System.out.println(library);
        System.out.println("#@#@#@#@#@#@#@#@#@#@#@#@#@##@#@#@#@");
        System.out.println(deepClonedCopy);

        assertEquals(4, library.getBooks().size());
        assertEquals(4, clonedLibrary.getBooks().size());
        assertEquals(5, deepClonedCopy.getBooks().size());
        assertNotEquals(deepClonedCopy.getBooks().size(), library.getBooks().size());
    }
}
