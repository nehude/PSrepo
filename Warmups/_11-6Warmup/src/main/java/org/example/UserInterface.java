package org.example;

public class UserInterface {
    private Library library;

    public UserInterface(Library library) {
        this.library = library;
    }


    public void start() {

    }

    public void displayMenu() {

    }

    public void handleUserInput() {

    }
}

/*Class: UserInterface
Responsibilities:
Handles user interactions and menu displays.
Communicates with the Library class to perform operations based on user input.

Relationships:
Contains an instance of the Library class.
Utilizes methods from the Library class for book-related operations.

Coding Techniques:
Uses a Scanner for user input processing.
While loops for displaying menus and handling user input until the user decides to exit.
Switch cases for processing different user menu options.*/
