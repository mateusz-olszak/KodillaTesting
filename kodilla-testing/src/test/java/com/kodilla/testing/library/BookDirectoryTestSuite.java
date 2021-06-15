package com.kodilla.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabase;

    @Test
    void testListBooksWithConditionsReturnList() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        Mockito.when(libraryDatabase.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        Mockito.when(libraryDatabase.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        Mockito.when(libraryDatabase.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        Mockito.when(libraryDatabase.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        List<Book> theListOOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOOfBooks15 = bookLibrary.listBooksWithCondition("Any Title");
        List<Book> theListOOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        Assertions.assertEquals(0, theListOOfBooks0.size());
        Assertions.assertEquals(15, theListOOfBooks15.size());
        Assertions.assertEquals(0, theListOOfBooks40.size());

    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);

        List<Book> bookList = bookLibrary.listBooksWithCondition("An");


        Assertions.assertEquals(0, bookList.size());
        Mockito.verify(libraryDatabase, Mockito.times(0)).listBooksWithCondition(anyString());
    }

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for (int n=1; n<=booksQuantity; n++){
            Book book = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(book);
        }
        return resultList;
    }


    @Test
    void testListBooksInHandsOfNoBooks(){
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Mateusz", "Olszak", "2134243213");

        List<Book> resultList = bookLibrary.listBooksInHandsOff(user);

        Assertions.assertEquals(0, resultList.size());
        Mockito.verify(libraryDatabase, Mockito.times(1)).listBooksInHandsOff(user);
    }

    @Test
    void testListBooksInHandsOfOneBook(){
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Mateusz", "Olszak", "2134243213");
        Mockito.when(libraryDatabase.listBooksInHandsOff(user)).thenReturn(generateListOfNBooks(1));

        List<Book> resultList = bookLibrary.listBooksInHandsOff(user);

        Assertions.assertEquals(1, resultList.size());
    }

    @Test
    void testListBooksInHandsOfFiveBooks(){
        BookLibrary bookLibrary = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Mateusz", "Olszak", "2134243213");
        Mockito.when(libraryDatabase.listBooksInHandsOff(user)).thenReturn(generateListOfNBooks(5));

        List<Book> resultList = bookLibrary.listBooksInHandsOff(user);

        Assertions.assertEquals(5, resultList.size());
    }

}
