package com.levelup.forestsandmonsters.game;

import java.awt.Point;

import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

public class GameMap {
    int numPositions = 100;


    public int getTotalPositions() {
        return numPositions;
    }

    public Position[][] getPositions() {
        Position[][] positions = new Position[0][0];
        return positions;
    }

    public Position calculatedPosition(final Position startingPosition, DIRECTION direction) {
        Position calculatedPosition = new Position(startingPosition.point.x, startingPosition.point.y);
        if(direction.equals(DIRECTION.NORTH)){
            calculatedPosition.point.y--;
        } else if (direction.equals(DIRECTION.SOUTH)){
            calculatedPosition.point.y++;
        } else if (direction.equals(DIRECTION.EAST)){
            calculatedPosition.point.x++;
        } else if (direction.equals(DIRECTION.WEST)){
            calculatedPosition.point.x--;
        }
        
        if(isPositionValid(calculatedPosition.point)){
            return calculatedPosition;
        }
        return startingPosition;
    }

    public boolean isPositionValid(Point positionCoordinates){
        return ((positionCoordinates.x <= 9 && positionCoordinates.x>=0) 
        && (positionCoordinates.y <= 9 && positionCoordinates.y>=0));
    }

}
