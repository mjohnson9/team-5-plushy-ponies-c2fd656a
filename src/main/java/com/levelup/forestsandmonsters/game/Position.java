package com.levelup.forestsandmonsters.game;

import java.awt.Point;

public class Position {
    Point point;

    public Position(int xCoordinates, int yCoordinates) {
        point = new Point(xCoordinates, yCoordinates);
    }

    public int getX() {
        return (int) point.getX();

    }

    public int getY() {
        return (int) point.getY();
    }

    public Object clone() {
        return new Position(this.getX(), this.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Position other = (Position) obj;
        if (this.getX() != other.getX()) {
            return false;
        }

        if (this.getY() != other.getY()) {
            return false;
        }

        return true;
    }
    @Override
    public String toString() {
        return this.getX() + " , " + this.getY();
    }
}
