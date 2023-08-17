package com.levelup.forestsandmonsters.game;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import com.levelup.forestsandmonsters.game.GameMap;

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
}
