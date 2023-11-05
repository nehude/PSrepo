package org.example;

import java.util.InputMismatchException;
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
                if (scanner.hasNextInt()) {
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
                            System.out.println("Input not valid: ");
                    }
                } else {
                    System.out.println("Sorry, please enter a number 1-10: ");
                    scanner.nextLine();
                }
            }
        }



    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {
        boolean validInput = false;
        do {
            try {
                System.out.print("Enter minimum price: ");
                double minPrice = scanner.nextDouble();
                System.out.print("Enter maximum price: ");
                double maxPrice = scanner.nextDouble();
                displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
                scanner.nextLine();
            }
        } while (!validInput);
        displayMenu();
    }

    private void processGetByMakeModelRequest() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter make: ");
                String make = scanner.next();
                System.out.print("Enter model: ");
                String model = scanner.next();

                List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
                if (!vehicles.isEmpty()) {
                    displayVehicles(vehicles);
                    validInput = true;
                } else {
                    System.out.println("No vehicles found for the given make and model.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid strings.");
                scanner.nextLine();
            }
        }
        displayMenu();
    }

    private void processGetByYearRequest() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter minimum year: ");
                int minYear = scanner.nextInt();
                System.out.print("Enter maximum year: ");
                int maxYear = scanner.nextInt();
                List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
                if (!vehicles.isEmpty()) {
                    displayVehicles(vehicles);
                    validInput = true;
                } else {
                    System.out.println("No vehicles found for the given year range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid years.");
                scanner.nextLine();
            }
        }
        displayMenu();
    }

    private void processGetByColorRequest() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter color: ");
                String color = scanner.next();
                List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
                if (!vehicles.isEmpty()) {
                    displayVehicles(vehicles);
                    validInput = true;
                } else {
                    System.out.println("No vehicles found for the given color.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid color.");
                scanner.nextLine();
            }
        }
        displayMenu();
    }

    private void processGetByMileageRequest() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter minimum mileage: ");
                int minMileage = scanner.nextInt();
                System.out.print("Enter maximum mileage: ");
                int maxMileage = scanner.nextInt();
                List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
                if (!vehicles.isEmpty()) {
                    displayVehicles(vehicles);
                    validInput = true;
                } else {
                    System.out.println("No vehicles found for the given mileage range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numbers for mileage.");
                scanner.nextLine();
            }
        }
        displayMenu();
    }

    private void processGetByVehicleTypeRequest() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter vehicle type: ");
                String vehicleType = scanner.next();
                List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
                if (!vehicles.isEmpty()) {
                    displayVehicles(vehicles);
                    validInput = true;
                } else {
                    System.out.println("No vehicles found for the given vehicle type.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid vehicle type.");
                scanner.nextLine();
            }
        }
        displayMenu();
    }


    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
        displayMenu();
    }

    private void processAddVehicleRequest() {
        boolean addAnotherVehicle = true;
        while (addAnotherVehicle) {
            int vin = 0;
            while (true) {
                try {
                    System.out.print("Enter VIN: ");
                    vin = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid VIN.");
                    scanner.nextLine();
                }
            }

            int year = 0;
            while (true) {
                try {
                    System.out.print("Enter year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid year.");
                    scanner.nextLine();
                }
            }


            String make = "";
            while (true) {
                System.out.print("Enter make: ");
                make = scanner.nextLine();
                if (!make.isEmpty()) {
                    break;
                }
                System.out.println("Invalid input. Make cannot be empty.");
            }
            String model = "";
            while (true) {
                System.out.print("Enter model: ");
                model = scanner.nextLine();
                if (!model.isEmpty()) {
                    break;
                    }
                System.out.println("Invalid input. Model cannot be empty.");
            }

            String vehicleType = "";
            while (true) {
                System.out.print("Enter vehicle type: ");
                vehicleType = scanner.nextLine();
                if (!vehicleType.isEmpty()) {
                    break;
                }
                System.out.println("Invalid input. Vehicle type cannot be empty.");
            }

                String color = "";
                while (true) {
                    System.out.print("Enter color: ");
                    color = scanner.nextLine();
                    if (!color.isEmpty()) {
                        break;
                    }
                    System.out.println("Invalid input. Color cannot be empty.");
                }

                int odometer = 0;
                while (true) {
                    try {
                        System.out.print("Enter odometer reading: ");
                        odometer = scanner.nextInt();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid odometer reading.");
                        scanner.nextLine();
                    }
                }

                double price = 0;
                while (true) {
                    try {
                        System.out.print("Enter price: ");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid price.");
                        scanner.nextLine();
                    }
                }

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
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid VIN (numeric value).");
                scanner.nextLine();
            }
        }
        displayMenu();
    }
}