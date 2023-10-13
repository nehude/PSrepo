package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicle = new Vehicle[20];

        vehicle[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicle[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicle[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicle[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicle[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicle[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.println("Enter 1, 2, 3, 4, 5, or 6: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                displayVehicleList(vehicle);
                break;
            case 2:
                searchByMake(vehicle);
                break;
            case 3:
                searchByPrice(vehicle);
                break;
            case 4:
                searchByColor(vehicle);
                break;
            case 5:
                addVehicle(vehicle);
                break;
            case 6:
                System.out.println("Have a good day.");
                break;
            default:
                System.out.println("Enter 1,2,3,4,5, or 6");
                break;
        }
    }

    public static void displayVehicleList(Vehicle[] vehicles){
        for (Vehicle v : vehicles){
            if (v != null){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
            }
        }
    }

    public static void searchByMake(Vehicle[] make) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter Make/Model:");
        String car = scanner.nextLine();

        boolean num = true;

        for (Vehicle v : make) {
            if (v != null && v.getMakeModel().equalsIgnoreCase(car)) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }

        if (num) {
            System.out.println("No cars available");
        }
    }
    public static void searchByPrice(Vehicle[] price) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter minimum price: ");
        double minimum = scanner.nextDouble();
        System.out.println("Please enter maximum price: ");
        double maximum = scanner.nextDouble();

        boolean num = true;

        for (Vehicle v : price) {
            if (v != null && v.getPrice() >= minimum && v.getPrice() <= maximum) {

                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }

        if (num) {
            System.out.println("No cars available");
        }
    }


    public static void searchByColor(Vehicle[] colorsearch) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter color: ");
        String color = scanner.nextLine();

        boolean num = true;

        for (Vehicle v : colorsearch) {
            if (v != null && v.getColor().equalsIgnoreCase(color)){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }

        if (num) {
            System.out.println("No cars available");
        }
    }

    public static void addVehicle(Vehicle[] vehicles) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter mileage: ");
        int odometerReading = scanner.nextInt();

        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vehicleId, makeModel, color, odometerReading, price);

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = newVehicle;
                System.out.println("Vehicle added successfully. ");
                System.out.printf("Vehicle ID: %d, Make/Model: %s, Color: %s, Mileage: %d, Price: %.2f%n", newVehicle.getVehicleId(), newVehicle.getMakeModel(), newVehicle.getColor(), newVehicle.getOdometerReading(), newVehicle.getPrice());
                return;

            }
        }
        System.out.println("array is full, cannot add");
    }
}
