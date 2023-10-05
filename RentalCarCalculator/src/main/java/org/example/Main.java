package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, what date would you like to pick up?");
        String pickupDate = scanner.nextLine();

        System.out.println("How many days would you like to rent for?");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Would you like an electronic toll tag for $3.95/day? (yes/no)");
        String tollTag = scanner.nextLine();
        double costTag = 0;

        switch (tollTag.toLowerCase()) {
            case "yes":
                costTag = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("please enter yes or no");
                return;
        }

        System.out.println("Would you like a GPS for $2.95/day? (yes/no)");
        String gps = scanner.nextLine();
        double costGPS = 0;

        switch (gps.toLowerCase()) {
            case "yes":
                costGPS = 2.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("please enter yes or no");
                return;
        }

        System.out.println("Would you like roadside assistance for $3.95/day? (yes/no)");
        String roadside = scanner.nextLine();
        double costRoadside = 0;

        switch (roadside.toLowerCase()) {
            case "yes":
                costRoadside = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("please enter yes or no");
                return;
        }

        System.out.println("What is your current age?");
        int age = scanner.nextInt();

        double basicCar = 29.99 * rentalDays;
        double optionsCost = costTag + costGPS + costRoadside;

        if (age < 25) {
            basicCar *= 1.3;
        }

        double totalCost = basicCar + optionsCost;

        System.out.printf("The total cost of the car is: $%.2f", totalCost);
    }
}


