package com.softserve.academy.edu10.pt;

class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;
    private String dateOfBirth;

    public Employee(int id, String name, String position, double salary, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Position: " + position +
                ", Salary: " + salary +
                ", Date of Birth: " + dateOfBirth;
    }
}