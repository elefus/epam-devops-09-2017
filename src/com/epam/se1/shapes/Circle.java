package com.epam.se1.shapes;

public class Circle extends GeometryShape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double calculateSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Circle {%s - %.3f}", super.toString(), radius);
//        return "Circle {" + super.toString() + " - " + radius + '}';
    }
}
