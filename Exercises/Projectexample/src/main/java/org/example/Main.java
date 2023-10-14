package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int storeSize = 20;
        store = new Store(storeSize);

        while (true) {
            displayHomeScreen();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    checkOutBook();
                    break;
                case 4:
                    checkInBook();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("Store Home Screen");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Check Out a Book");
        System.out.println("4. Check In a Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void showAvailableBooks() {
        store.showAvailableBooks();
        // Implement logic for handling user choice after showing available books
    }

    private static void showCheckedOutBooks() {
        store.showCheckedOutBooks();
        // Implement logic for handling user choice after showing checked out books
    }

    private static void checkOutBook() {
        System.out.println("Enter the ID of the book you want to check out:");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        store.checkOutBook(bookId, name);
        // Implement logic for handling user choice after checking out a book
    }

    private static void checkInBook() {
        System.out.println("Enter the ID of the book you want to check in:");
        int bookId = scanner.nextInt();
        store.checkInBook(bookId);
        // Implement logic for handling user choice after checking in a book
    }
}
