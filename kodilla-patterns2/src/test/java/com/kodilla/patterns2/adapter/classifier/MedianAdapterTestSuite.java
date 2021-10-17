package com.kodilla.patterns2.adapter.classifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.MedianAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        IntStream.iterate(1, n -> n+1).limit(5)
                .forEach(n -> bookSet.add(new Book(
                        "Author"+n,
                        "Title"+n,
                        1900+n,
                        "Signature"+n)
                        ));
        // When
        int median = adapter.publicationYearMedian(bookSet);
        // Then
        assertEquals(1903,median);
    }

}
