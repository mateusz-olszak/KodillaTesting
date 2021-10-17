package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> books = new HashMap<>();
        for (Book book : bookSet) {
            books.put(
                    new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(book.getAuthor(),book.getTitle(),book.getPublicationYear())
            );
        }
        return medianPublicationYear(books);
    }
}
