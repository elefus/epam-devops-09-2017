package com.epam.se1.shapes;

class Rectangle extends GeometryShape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateSquare() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle {" + super.toString() + " - " + width + "x" + height + "}";
    }
}
