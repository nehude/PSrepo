package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        init();
        display();
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    private void displayMenu() {
        System.out.println("Menu Options:");
        System.out.println("1. Search vehicles by price range");
        System.out.println("2. Search vehicles by make and model");
        System.out.println("3. Search vehicles by year range");
        System.out.println("4. Search vehicles by color");
        System.out.println("5. Search vehicles by mileage range");
        System.out.println("6. Search vehicles by type");
        System.out.println("7. Display all vehicles");
        System.out.println("8. Add a new vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    public void display() {
        init();
        displayMenu();

        boolean exit = false;
        while (!exit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    private void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.next();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.next();
        displayVehicles(dealership.getVehiclesByType(vehicleType));
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {
        boolean addAnotherVehicle = true;
        while (addAnotherVehicle) {
            System.out.print("Enter VIN: ");
            int vin = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter make: ");
            String make = scanner.nextLine();
            System.out.print("Enter model: ");
            String model = scanner.nextLine();
            System.out.print("Enter vehicle type: ");
            String vehicleType = scanner.nextLine();
            System.out.print("Enter color: ");
            String color = scanner.nextLine();
            System.out.print("Enter odometer reading: ");
            int odometer = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(newVehicle);

            System.out.println("Vehicle added successfully!");

            System.out.print("Do you want to add another vehicle? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            scanner.nextLine();

            if (choice.equals("no")) {
                addAnotherVehicle = false;
            }
        }
        displayMenu();
    }

    private void processRemoveVehicleRequest() {
        boolean removeAnotherVehicle = true;
        while (removeAnotherVehicle) {
            System.out.print("Enter VIN of the vehicle to remove: ");
            int vin = scanner.nextInt();
            scanner.nextLine();

            boolean removed = dealership.removeVehicle(vin);
            if (removed) {
                System.out.println("Vehicle removed successfully!");
            } else {
                System.out.println("Vehicle with VIN " + vin + " not found.");
            }

            System.out.print("Do you want to remove another vehicle? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("no")) {
                removeAnotherVehicle = false;
            }
        }
        displayMenu();
    }
}