CREATE DATABASE DEALERSHIPIN;

CREATE TABLE Dealerships(
    dealership_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone VARCHAR(15) NOT NULL);
    
CREATE TABLE Vehicles(
    vin INT PRIMARY KEY,
    year INT,
    make VARCHAR(30),
    model VARCHAR(30),
    vehicleType VARCHAR(30),
    color VARCHAR(15),
    odometer INT,
    price float(10, 2));

CREATE TABLE Inventory(
    dealership_id INT,
    vin INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles(vin));

CREATE TABLE SalesContracts(
    sales_id INT PRIMARY KEY AUTO_INCREMENT,
    contractDate DATETIME,
    name VARCHAR(50),
    email VARCHAR(100),
    isFinanced bit,
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles(vin));

CREATE TABLE LeaseContracts(
    lease_id INT PRIMARY KEY AUTO_INCREMENT,
    contractDate DATETIME,
    name VARCHAR(50),
    email VARCHAR(100),
    vin INT,
    dealership_id INT,
    FOREIGN KEY (dealership_id) REFERENCES Dealerships(dealership_id),
    FOREIGN KEY (vin) REFERENCES Vehicles(vin));

INSERT INTO Dealerships (name, address, phone) VALUES
('Fast Track Motors', '100 Speedway Blvd', '202-555-0198'),
('Urban Drive Autos', '550 City Plaza', '202-555-0147'),
('Green Auto Hub', '200 Eco Lane', '202-555-0234'),
('Luxury Wheels Inc', '755 Highline Park', '202-555-0112'),
('Family Rides Plaza', '321 Suburban Ave', '202-555-0133'),
('Sunshine Car Sales', '400 Sunny Rd', '202-555-0176'),
('Electric Avenue Autos', '600 Volt St', '202-555-0165'),
('Riverside Auto Market', '220 Riverbank Dr', '202-555-0189'),
('Mountain View Dealership', '900 Mountain Rd', '202-555-0151'),
('Adventure Motors', '1010 Explorer Blvd', '202-555-0123');


INSERT INTO Vehicles (vin, year, make, model, vehicleType, color, odometer, price) VALUES
(258369, 2022, 'Porsche', '911', 'Sports', 'Midnight Blue', 4000, 90000.99),
(987654, 2020, 'Toyota', 'Camry', 'Sedan', 'Black', 15000, 25000.50),
(123456, 2019, 'Honda', 'Civic', 'Sedan', 'Blue', 22000, 21000.00),
(654321, 2018, 'Chevrolet', 'Impala', 'Sedan', 'White', 30000, 19000.95),
(192837, 2022, 'Tesla', 'Model 3', 'Electric', 'Red', 5000, 35000.99),
(564738, 2021, 'BMW', 'X5', 'SUV', 'Grey', 10000, 55000.75),
(298765, 2020, 'Audi', 'A4', 'Sedan', 'Black', 12000, 33000.50),
(876543, 2022, 'Mercedes', 'C-Class', 'Sedan', 'Blue', 8000, 40000.00),
(345123, 2019, 'Volkswagen', 'Golf', 'Hatchback', 'White', 18000, 23000.95),
(789456, 2018, 'Subaru', 'Outback', 'SUV', 'Green', 25000, 22000.99),
(321654, 2021, 'Nissan', 'Rogue', 'SUV', 'Silver', 11000, 27000.75),
(654987, 2019, 'Hyundai', 'Elantra', 'Sedan', 'Red', 14000, 18000.50),
(852963, 2018, 'Kia', 'Sorento', 'SUV', 'Black', 30000, 20000.00),
(741258, 2020, 'Mazda', 'CX-5', 'SUV', 'Blue', 17000, 29000.95),
(369852, 2019, 'Ford', 'F-150', 'Truck', 'White', 21000, 31000.99),
(147258, 2021, 'Jeep', 'Wrangler', 'SUV', 'Yellow', 9000, 36000.75),
(963852, 2020, 'Dodge', 'Charger', 'Sedan', 'Grey', 13000, 28000.50),
(789123, 2018, 'Chevrolet', 'Corvette', 'Sports', 'Red', 8000, 45000.00),
(456789, 2022, 'Lexus', 'RX', 'SUV', 'Black', 6000, 47000.95),
(321987, 2021, 'Toyota', 'Tacoma', 'Truck', 'Green', 15000, 32000.99);

INSERT INTO Inventory (dealership_id, vin) VALUES
(1, 987654),
(2, 123456),
(2, 654321),
(3, 192837),
(3, 564738),
(4, 298765),
(4, 876543),
(5, 345123),
(5, 789456),
(6, 321654),
(6, 654987),
(7, 852963),
(7, 741258),
(8, 369852),
(8, 147258),
(9, 963852),
(9, 789123),
(10, 456789),
(10, 321987),
(1, 258369);

INSERT INTO SalesContracts (contractDate, name, email, isFinanced, vin, dealership_id) VALUES
('2023-01-15 10:30:00', 'Tony Stark', 'tony.stark@example.com', 1, 987654, 1),
('2023-02-20 14:45:00', 'Bruce Wayne', 'bruce.wayne@example.com', 0, 123456, 2),
('2023-03-10 09:15:00', 'Clark Kent', 'clark.kent@example.com', 1, 654321, 2),
('2023-04-05 13:00:00', 'Diana Prince', 'diana.prince@example.com', 0, 192837, 3),
('2023-05-22 11:20:00', 'Peter Parker', 'peter.parker@example.com', 1, 564738, 3),
('2023-06-18 15:10:00', 'Sherlock Holmes', 'sherlock.holmes@example.com', 0, 298765, 4),
('2023-07-08 08:45:00', 'Lara Croft', 'lara.croft@example.com', 1, 876543, 4),
('2023-08-30 12:30:00', 'James Bond', 'james.bond@example.com', 0, 345123, 5),
('2023-09-14 09:50:00', 'Luke Skywalker', 'luke.skywalker@example.com', 1, 789456, 5),
('2023-10-25 14:15:00', 'Hermione Granger', 'hermione.granger@example.com', 0, 321654, 6);

INSERT INTO LeaseContracts (contractDate, name, email, vin, dealership_id) VALUES
('2023-01-05 11:30:00', 'Walter White', 'walter.white@example.com', 852963, 7),
('2023-02-10 14:20:00', 'Don Draper', 'don.draper@example.com', 741258, 7),
('2023-03-15 09:45:00', 'Rick Grimes', 'rick.grimes@example.com', 369852, 8),
('2023-04-20 13:10:00', 'Jack Sparrow', 'jack.sparrow@example.com', 147258, 8),
('2023-05-25 11:50:00', 'Katniss Everdeen', 'katniss.everdeen@example.com', 963852, 9),
('2023-06-30 15:30:00', 'Indiana Jones', 'indiana.jones@example.com', 789123, 9),
('2023-07-08 09:00:00', 'Ellen Ripley', 'ellen.ripley@example.com', 456789, 10),
('2023-08-12 12:45:00', 'Jon Snow', 'jon.snow@example.com', 321987, 10),
('2023-09-18 09:15:00', 'Neo', 'neo@example.com', 258369, 1),
('2023-10-22 14:40:00', 'Sarah Connor', 'sarah.connor@example.com', 564738, 3);

SELECT * 
FROM Dealerships;

SELECT v.vin, v.make, v.model, v.year, v.color
FROM Vehicles v
JOIN Inventory i ON v.vin = i.vin
WHERE i.dealership_id = 2;

SELECT * 
FROM Vehicles 
WHERE vin = 987654;

SELECT d.name, d.address, d.phone
FROM Dealerships d 
JOIN Inventory i ON d.dealership_id = i.dealership_id
WHERE i.VIN = 321654;

SELECT d.name, d.address, d.phone
FROM Dealerships d 
JOIN Inventory i ON d.dealership_id = i.dealership_id
JOIN Vehicles v ON i.vin = v.vin
WHERE v.color = 'Black' AND v.make = 'Toyota' AND v.model = 'Camry';

SELECT sc.*, d.name, d.address
FROM SalesContracts sc
JOIN Dealerships d ON sc.dealership_id = d.dealership_id
WHERE sc.contractDate BETWEEN '2023-01-15' AND '2023-10-25'
AND d.dealership_id = 2;