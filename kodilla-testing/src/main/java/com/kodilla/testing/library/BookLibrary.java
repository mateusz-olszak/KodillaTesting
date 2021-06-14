package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookLibrary {

    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment){
        List<Book> bookList = new ArrayList<>();

        if (titleFragment.length() < 3)
            return bookList;

        else if (libraryDatabase.listBooksWithCondition(titleFragment).size() > 20)
            return bookList;

        else
            bookList = libraryDatabase.listBooksWithCondition(titleFragment);
            return bookList;
    }

    public List<Book> listBooksInHandsOff(LibraryUser libraryUser){
        List<Book> bookList = new ArrayList<>();

        for(Book book : libraryDatabase.listBooksInHandsOff(libraryUser)){
            bookList.add(book);
        }

        return bookList;
    }

}
