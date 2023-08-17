package com.levelup.forestsandmonsters.game;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.Point;

import org.junit.Test;
import org.springframework.util.Assert;

import com.levelup.forestsandmonsters.game.GameMap;
import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

public class GameMapTest {



    @Test
    public void GameMapInitializeTest(){
        GameMap testObj = new GameMap();
        assertNotNull("GameMap not null", testObj);
    }
    @Test
    public void numPositionsTest(){
        GameMap testObj = new GameMap();
        int numPositions = testObj.getTotalPositions();
        assertEquals(100,numPositions);
    }

    @Test
    public void getPostionsTest(){
        GameMap testObj = new GameMap();
        Position[][] returnedPositions = testObj.getPositions();
        assertNotNull("Returned Positions are not null", returnedPositions);
    }

    @Test
    public void getPostionsLengthTest(){
        GameMap testObj = new GameMap();
        System.out.println("getTotalPos:"+testObj.getTotalPositions());
        System.out.println(testObj.numPositions+","+testObj.getTotalPositions());
        assertEquals(testObj.numPositions, testObj.getTotalPositions());
    }

    @Test 
    public void calculatePositionTest(){
        GameMap testObj = new GameMap();
        Position startingPosition = new Position(5, 5);
        Position calculatedPosition = testObj.calculatedPosition(startingPosition, DIRECTION.NORTH);
        Position expectedFinalPosition = new Position(5,4);
        
        System.out.println("sp: " + startingPosition.point + "cp: " + calculatedPosition.point);
        assertNotNull("Returned calculated position is not null", calculatedPosition);
        assertEquals(expectedFinalPosition.point, calculatedPosition.point);
    }

    @Test
    public void isPositionValidTest(){
        GameMap testObj = new GameMap();
        assertTrue("This is valid", testObj.isPositionValid(new Point(5, 5)));
        assertFalse("This is NOT valid", testObj.isPositionValid(new Point(10, 5)));
        assertFalse("This is NOT valid", testObj.isPositionValid(new Point(5, 10)));
    }
}
