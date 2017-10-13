package com.epam.se1.shapes;

import java.io.Serializable;

abstract class GeometryShape implements CalculableSquare, Cloneable, Serializable {

    private int x;
    private int y;

    public GeometryShape() {}

    public GeometryShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "GeometryShape [" + x + ", " + y + "]";
    }
}
