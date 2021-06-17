package com.kodilla.stream.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {

    @Test
    public void testGetList(){
        BookDiretory bookDiretory = new BookDiretory();

        List<Book> books = bookDiretory.getTheBookList();

        int result = (int) IntStream.range(0, books.size())
                .filter(book -> books.get(book).getYearOfPublication() > 2007)
                .count();

        Assertions.assertEquals(3, result);
    }

}
