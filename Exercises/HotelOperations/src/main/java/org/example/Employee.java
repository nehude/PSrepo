package org.example;

import java.time.LocalTime;

public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;
    private double punchOutTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked, double punchInTime, double punchOutTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        double regularHours;
        double overtimeHours;

        if (hoursWorked <= 40) {
            regularHours = hoursWorked;
            overtimeHours = 0;
        } else {
            regularHours = 40;
            overtimeHours = hoursWorked - 40;
        }

        double totalPay = (regularHours * payRate) + (overtimeHours * payRate * 1.5);
        return totalPay;
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }
    }

    public void punchIn() {
        punchInTime = LocalTime.now().toSecondOfDay() / 3600.0;
    }

    public void punchOut() {
        if (punchInTime > 0) {
            double currentTime = LocalTime.now().toSecondOfDay() / 3600.0;
            double hoursWorkedToday = currentTime - punchInTime;
            hoursWorked += hoursWorkedToday;
            punchInTime = 0; // Reset punchInTime after punching out
        } else {
            System.out.println("Employee has not punched in.");
        }
    }
}