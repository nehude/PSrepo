package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What is the first number?");
        Scanner scanner = new Scanner(System.in);

        try {
            double firstNumber = scanner.nextDouble();

            System.out.println("What is the second  number?");
            double secondNumber = scanner.nextDouble();

            double quotient = firstNumber / secondNumber;
            System.out.println("The result is " + quotient);
        } catch (ArithmeticException ex) {
            System.out.println("You can't divide by zero");
        } catch (InputMismatchException ex) {
            System.out.println("I need a number!");
        }
    }
}
