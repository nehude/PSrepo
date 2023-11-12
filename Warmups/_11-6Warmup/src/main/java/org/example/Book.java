package org.example;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void checkOut() {

    }

    public void returnBook() {

    }
}

/*Class: Book
Responsibilities:
Represents data of a real-world book object.
Manages book-related information such as title, author, ISBN, and availability status.
Provides methods for book check-out and return operations.

Relationships:
No direct relationships with other classes, but instances of Book class are used within Library and LibraryMember classes.

Coding Techniques:
Constructors for initializing book properties.
Getter and setter methods for accessing and modifying private properties.
Conditional statements for managing book availability (if-else statements).
No need for complex control structures like switch cases or loops in this class./*
