package org.example;
// imports this library for scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // welcomes and asks user to input first number
        System.out.println("Welcome to the basic calculator");
        System.out.println("Enter the first number:");
        // use scanner to allow user to write input
        Scanner scanner = new Scanner(System.in);
        float firstNumber = scanner.nextFloat();
        // asks for second number
        System.out.println("Enter the second number:");
        float secondNumber = scanner.nextFloat();
        // prints the possible calculations and asks user to enter an option
        System.out.println("Possible Calculations:");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");
        System.out.println("Please select an option:");
        String answer = scanner.next();
        // if statement for addition
        if (answer.equalsIgnoreCase("A")) {
            float sum = firstNumber + secondNumber;
            System.out.printf("%.2f + %.2f = %.2f", firstNumber, secondNumber, sum);
        }   // else if for subtraction
        else if (answer.equalsIgnoreCase("S")) {
            float subtract = firstNumber - secondNumber;
            System.out.printf("%.2f - %.2f = %.2f", firstNumber, secondNumber, subtract);
        }   // else if for multiplication
        else if (answer.equalsIgnoreCase("M")) {
            float multiply = firstNumber * secondNumber;
            System.out.printf("%.2f * %.2f = %.2f", firstNumber, secondNumber, multiply);
        }   // else if for division
        else if (answer.equalsIgnoreCase("D")) {
            float divide = firstNumber / secondNumber;
            System.out.printf("%.2f / %.2f = %.2f", firstNumber, secondNumber, divide);
        }   // else for an input that's not a,s,m,d
        else {
            System.out.println("not an option");
        }
    }
}