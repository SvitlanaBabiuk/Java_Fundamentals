package com.softserve.edu08.hw;

public class Student extends Person {// Ok

    private int course;

    public Student(FullName fullName, int age, int course) {
        super(fullName, age);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String info() {
        return super.info() + ", course: " + course;
    }

    @Override
    public String activity() {
        return "I study at university";
    }
}
