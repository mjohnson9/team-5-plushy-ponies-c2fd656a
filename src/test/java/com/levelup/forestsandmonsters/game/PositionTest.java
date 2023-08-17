package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class PositionTest {
    
    
    @Test
    public void positionTest() {
        Position testObj = new Position();
        assertNotNull("Position not null", testObj);
    }

}
