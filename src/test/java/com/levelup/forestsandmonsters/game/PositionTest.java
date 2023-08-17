package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class PositionTest {
    
    
    @Test
    public void positionTest() {
        Position testObj = new Position();
        assertNotNull("Position not null", testObj);
    }

    public void positionTestXY() {
        Position testObj = new Position(1,2);
        assertNotNull(testObj);
    }
}
