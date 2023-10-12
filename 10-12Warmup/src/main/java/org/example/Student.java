package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private int yearInCollege;
    private boolean isInternationalStudent;
    private String address;

    public Student(String firstName, String lastName, String studentID, int yearInCollege, boolean isInternationalStudent, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.yearInCollege = yearInCollege;
        this.isInternationalStudent = isInternationalStudent;
        this.address = address;
    }

    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }
    public void greeting() {
        System.out.println("Hi, my name is " + firstName + " " + lastName + "!");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getStudentID() {

        return studentID;
    }

    public void setStudentID(String studentID) {

        this.studentID = studentID;
    }

    public int getYearInCollege() {

        return yearInCollege;
    }

    public void setYearInCollege(int yearInCollege) {

        this.yearInCollege = yearInCollege;
    }

    public boolean isInternationalStudent() {

        return isInternationalStudent;
    }

    public void setInternationalStudent(boolean internationalStudent) {

        isInternationalStudent = internationalStudent;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }
}

