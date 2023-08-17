package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.levelup.forestsandmonsters.game.GameController;

public class GameControllerTest {
    @Test
    public void initializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.status);
    }

    @Test
    public void getTotalPositionsIs100() {
        GameController testObj = new GameController();
        assertEquals(testObj.getTotalPositions(), 100);
    }

    @Test
    public void createCharacterExists() {
        GameController testObj = new GameController();
        testObj.createCharacter("name");
    }
}
