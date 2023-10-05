package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please enter your name:");

        Scanner scanner = new Scanner(System.in);
        String employeeName = scanner.nextLine();

        System.out.println("Hello " + employeeName + ", please enter hours worked:");
        double hoursWorked = scanner.nextDouble();

        System.out.println("Please enter your pay rate:");
        double payRate = scanner.nextDouble();


        if (hoursWorked > 40) {
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * payRate * 1.5;
            double grossPay = 40 * payRate + overtimePay;
            System.out.println(employeeName + ", your gross pay is " + grossPay);
        }
        else {
            double grossPay = hoursWorked * payRate;
            System.out.println(employeeName + ", your gross pay is " + grossPay);
        }
    }
}
