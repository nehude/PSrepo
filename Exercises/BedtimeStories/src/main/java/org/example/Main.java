package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the story you want to read (goldilocks.txt, hansel_and_gretel.txt, or mary_had_a_little_lamb.txt): ");
            String fileName = scanner.nextLine();

            try (FileInputStream fis = new FileInputStream("src/main/resources/" + fileName);
                 Scanner fileScanner = new Scanner(fis)) {

                int lineNumber = 1;

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(lineNumber++ + " " + line);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("That story is not available");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}








