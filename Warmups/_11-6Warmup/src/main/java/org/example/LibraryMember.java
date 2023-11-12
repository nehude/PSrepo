package org.example;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private String libraryCardNumber;
    private ArrayList<Book> checkedOutBooks;

    public LibraryMember(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public void setLibraryCardNumber(String libraryCardNumber) {
        this.libraryCardNumber = libraryCardNumber;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void checkOutBook(Book book) {

    }

    public void returnBook(Book book) {

    }
}

/*Class: LibraryMember
Responsibilities:
Represents data of a library member.
Manages checked-out books and allows check-out and return operations for the member.

Relationships:
Contains an ArrayList of Book objects representing the books checked out by the library member.
Utilizes Book class methods for book-related operations.

Coding Techniques:
ArrayList for managing a dynamic list of checked-out books.
Methods for book check-out and return operations.
Conditional statements for managing book availability (if-else statements).*/

