package com.epam.se1.shapes;

public class GeometryExample {

    public static void main(String[] args) {
        int width = 5;
        int height = 2;
        Rectangle rectangle = new Rectangle(width, height);
        printSquare(rectangle);

        Rectangle inPosition = new Rectangle(10, 10, 1, 3);
        printSquare(inPosition);

        Circle circle = new Circle(5);
        printSquare(circle);

        Circle circleInPosition = new Circle(5, 5, 10);
        printSquare(circleInPosition);

        System.out.println(CalculableSquare.a);
    }

    private static void printSquare(CalculableSquare object) {
        System.out.printf("%s square: %.3f%n", object, object.calculateSquare());
    }
}
