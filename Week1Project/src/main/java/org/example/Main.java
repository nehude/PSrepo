package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, which calculator would you like to use?");
        System.out.println("Calculator 1: Mortgage Calculator");
        System.out.println("Calculator 2: Future Value Calculator");
        System.out.println("Calculator 3: Annuity Calculator");
        System.out.println("Please enter 1, 2, or 3 to continue:");
        int userChoice = scanner.nextInt();

        switch (userChoice){
            case 1:
                mortgageCalculator();
                break;
            case 2:
                futureValueCalculator();
                break;
            case 3:
                annuityCalculator();
                break;
            default:
                System.out.println("not a valid input");
        }
    }
    private static void mortgageCalculator() {
        System.out.println("Welcome to the Mortgage Calculator!");
        System.out.println("This calculator will calculate the monthly payment for your loan /n and how much interest you will pay over the life of the loan");

        Scanner scanner = new Scanner(System.in);

        System.out.println("First, please enter the principal amount of the loan:");
        double userPrincipal = scanner.nextDouble();
        System.out.println("Please enter the interest rate percentage:");
        double userInterest = scanner.nextDouble();
        System.out.println("Please enter the loan length in years:");
        double userLength = scanner.nextDouble();

        double monthlyInterest = userInterest / 12 / 100;
        double monthlyLength = userLength * 12;

        double monthlyPayment = userPrincipal * monthlyInterest * Math.pow(1 + monthlyInterest, monthlyLength) / (Math.pow(1 + monthlyInterest, monthlyLength) - 1);
        double totalInterest = (monthlyPayment * monthlyLength) - userPrincipal;

        System.out.printf("A $%.2f loan at %.2f%% interest for %.2f years would have a $%.2f monthly payment with a total interest of $%.2f", userPrincipal, userInterest, userLength, monthlyPayment, totalInterest);


    }
    private static void futureValueCalculator() {
        System.out.println("Welcome to the Future Value Calculator!");
        System.out.println("This calculator will calculate the future of a one-time deposit assuming compound interest.");
        System.out.println("It is used to help you decide how much a CD will be worth when it matures.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("First, please enter the deposit amount:");
        double userDeposit = scanner.nextDouble();
        System.out.println("Please enter the interest rate percentage:");
        double userInterest = scanner.nextDouble();
        System.out.println("Please enter the length of deposit in years:");
        double userLength = scanner.nextDouble();

        double dailyInterest = userInterest / 100 / 365;
        double daysLength = userLength * 365;

        double futureValue = userDeposit * Math.pow(1 + dailyInterest, daysLength);
        double totalInterest = futureValue - userDeposit;

        System.out.printf("If you deposit $%.2f in a CD that earns %.2f%% interest and matures in %.2f years,%n", userDeposit, userInterest, userLength);
        System.out.printf("your CD's ending balance will be $%.2f and you would have earned $%.2f in interest.%n", futureValue, totalInterest);
        System.out.println("Note: The numbers assume daily compounding.");

    }
    private static void annuityCalculator() {
        System.out.println("Welcome to the Annuity Calculator!");
        System.out.println("This calculator will calculate the present value of an ordinary annuity.");

        Scanner scanner = new Scanner(System.in);

        System.out.println("First, please enter the monthly payout:");
        double userPayout = scanner.nextDouble();
        System.out.println("Please enter the expected interest rate percentage:");
        double userInterest = scanner.nextDouble();
        System.out.println("Please enter the years to pay out:");
        double userLength = scanner.nextDouble();

        double monthlyInterest = userInterest / 12 /100;
        double monthsLength = userLength * 12;

        double presentValue = userPayout * ((1 - Math.pow(1 + monthlyInterest, -monthsLength))/monthlyInterest);
        

        System.out.printf("To fund an annuity that pays $%.2f monthly for %.2f years and earns an expected %.2f%% interest,%n", userPayout, userInterest, userLength);
                System.out.printf("you would need to invest $%.2f today.%n", presentValue);
    }
}