package com.levelup.forestsandmonsters.game;

import java.awt.Point;

import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

public class GameMap {

    private final int MAP_LIMIT_TOP = 9;
    private final int MAP_LIMIT_BOTTOM = 0;

    int numPositions =100;
    Position[][] positions;

    public GameMap(){
       int xLen = 10;
       int yLen = 10;
       positions = new Position[xLen][yLen];
       for(int x = 0; x < xLen ; x++){
            for(int y=0; y<yLen; y++){
                positions[x][y] = new Position(x,y);
            }
       }
    }


    public int getTotalPositions() {
        return positions.length*positions[0].length; 
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
        return ((positionCoordinates.x <= MAP_LIMIT_TOP && positionCoordinates.x>=MAP_LIMIT_BOTTOM) 
        && (positionCoordinates.y <= MAP_LIMIT_TOP && positionCoordinates.y>=MAP_LIMIT_BOTTOM));
    }

}
