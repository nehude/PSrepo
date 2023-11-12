package org.example;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private String libraryName;

    public Library(String libraryName) {
        this.books = new ArrayList<>();
        this.libraryName = libraryName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(Book book) {

    }

    public Book findBookByISBN(String ISBN) {

        return null;
    }

    public void listAvailableBooks() {

    }
}

/*Class: Library
        Responsibilities:
        Manages a collection of books (Book objects).
        Provides methods for adding books, finding books by ISBN, and listing available books.
        Does not deal with user interaction directly.

        Relationships:
        Contains an ArrayList of Book objects.
        Utilizes Book class methods for book-related operations.

        Coding Techniques:
        ArrayList for managing a dynamic list of books.
        Methods for adding, searching, and listing books.
        No complex control structures are needed in this class.*/
