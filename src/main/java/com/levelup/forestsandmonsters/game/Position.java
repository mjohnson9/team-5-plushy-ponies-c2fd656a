package com.levelup.forestsandmonsters.game;
import java.awt.Point;

public class Position {
    Point point;
    public Position(){
    }
    public Position(int xCoordinates, int yCoordinates){
        point = new Point(xCoordinates, yCoordinates);
    }
}