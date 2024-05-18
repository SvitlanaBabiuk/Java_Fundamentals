package com.softserve.academy.edu06.pt;

public class ColorLine extends Line {
    private String color;

    public ColorLine(Point point1, Point point2, String color) {
        super(point1, point2);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void Pint() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ColorLine{" +
                "color='" + color + '\'' +
                ", point1=" + getPoint1() +
                ", point2=" + getPoint2() +
                '}';
    }

}
