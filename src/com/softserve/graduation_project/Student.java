package com.softserve.graduation_project;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int course;
    private double grade;

    public Student(int id, String name, int course, double grade) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.grade = grade;
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

    public double getGrade() {
        return grade;
    }

    public double setGrade(double grade) {
        this.grade = grade;
        return grade;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student {" +
                ",\n name= '" + name + '\'' +
                ",\n course= " + course +
                ",\n grade= " + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && course == student.course && grade == student.grade && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, course, grade);
    }

}





