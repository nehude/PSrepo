package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] library = new Book[20];

        library[0] = new Book(1, "9780061122415", "To Kill a Mockingbird", false, "");
        library[1] = new Book(2, "9780141988478", "1984", false, "");
        library[2] = new Book(3, "9780060935467", "The Catcher in the Rye", false, "");
        library[3] = new Book(4, "9780062561029", "The Great Gatsby", false, "");
        library[4] = new Book(5, "9780061120084", "Lord of the Flies", false, "");
        library[5] = new Book(6, "9780547928227", "The Hobbit", false, "");
        library[6] = new Book(7, "9781400079988", "One Hundred Years of Solitude", false, "");
        library[7] = new Book(8, "9780143127660", "Moby-Dick", false, "");
        library[8] = new Book(9, "9781451673319", "The Grapes of Wrath", false, "");
        library[9] = new Book(10, "9780140283334", "Brave New World", false, "");
        library[10] = new Book(11, "9780743273565", "The Lord of the Rings", false, "");
        library[11] = new Book(12, "9780060850524", "Fahrenheit 451", false, "");
        library[12] = new Book(13, "9781400033416", "The Kite Runner", false, "");
        library[13] = new Book(14, "9780062315007", "The Alchemist", false, "");
        library[14] = new Book(15, "9780143039959", "The Book Thief", false, "");
        library[15] = new Book(16, "9780316769488", "To Kill a Mockingbird", false, "");
        library[16] = new Book(17, "9780060256654", "Where the Sidewalk Ends", false, "");
        library[17] = new Book(18, "9780061122415", "The Da Vinci Code", false, "");
        library[18] = new Book(19, "9780679783268", "The Road", false, "");
        library[19] = new Book(20, "9780385534635", "The Goldfinch", false, "");

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("LIBRARY HOME SCREEN");
            System.out.println("What would you like to do today?");
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. exit");
            System.out.println("Please enter 1,2,3");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    availableBooks(library);
                    break;
                case 2:
                    checkedOut(library);
                    break;
                case 3:
                    System.out.println("Goodbye. Have a good day.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter 1,2,3, or 4");
                    break;
            }
        }
    }

    public static void availableBooks(Book[] books) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available Books:");
            boolean available = false;

            for (Book book : books) {
                if (!book.isCheckedOut()) {
                    System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
                    available = true;
                }
            }

            if (!available) {
                System.out.println("No available books.");
                break;
            }

            System.out.println("Enter the title of the book you want to check out, or enter '0' to go back to the Home Screen: ");
            String bookTitle = scanner.nextLine();

            if (bookTitle.equals("0")) {
                break;
            }

            boolean bookFound = false;

            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(bookTitle) && !book.isCheckedOut()) {
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();

                    book.checkOut(userName);
                    System.out.println("Book checked out successfully by " + userName);
                    bookFound = true;
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("not a valid input.");
            }
        }
    }


    public static void checkedOut(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Checked Out Books:");
            boolean checkedOut = false;

            for (Book book : books) {
                if (book.isCheckedOut()) {
                    System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked Out By: " + book.getCheckedOutTo());
                    checkedOut = true;
                }
            }

            if (!checkedOut) {
                System.out.println("No books are currently checked out.");
                return;
            }

            System.out.println("Enter the ID of the book to check in, or enter '0' to go back to the home screen:");
            int bookId = scanner.nextInt();
            scanner.nextLine();

            if (bookId == 0) {
                exit = true;
            } else {
                boolean bookFound = false;
                for (Book book : books) {
                    if (book.getId() == bookId && book.isCheckedOut()) {
                        book.checkIn();
                        System.out.println("Book checked in successfully.");
                        bookFound = true;
                        break;
                    }
                }
                if (!bookFound) {
                    System.out.println("No checked out book found with the given ID.");
                }
            }
        }
    }
}