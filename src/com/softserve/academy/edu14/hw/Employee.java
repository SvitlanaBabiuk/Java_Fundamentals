package com.softserve.academy.edu14.hw;

public record Employee(String name) {

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
