package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    private Dealership dealership;

    //Small thing, but this method is a good candidate for being static and
    //to let the FileManager have a private constructor
    public Dealership getDealership() {
        //This variable isn't necessary
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner(fis);
            scanner.hasNextLine();
            dealership = new Dealership("Neha's Cars", "123 address", "123-4567");

            if (scanner.hasNextLine()) {
                scanner.nextLine();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] vehicleData = line.split("\\|");
                    int vin = Integer.parseInt(vehicleData[0]);
                    int year = Integer.parseInt(vehicleData[1]);
                    String make = vehicleData[2];
                    String model = vehicleData[3];
                    String vehicleType = vehicleData[4];
                    String color = vehicleData[5];
                    int odometer = Integer.parseInt(vehicleData[6]);
                    double price = Double.parseDouble(vehicleData[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return dealership;
    }
    public void saveDealership(Dealership dealership) {
        try (FileWriter writer = new FileWriter("src/main/resources/inventory.csv")) {
            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to update file");
        }
    }
}

