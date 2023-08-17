package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import com.levelup.forestsandmonsters.game.GameController;

public class GameControllerTest {
    @Test
    public void initializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.status);
    }

}
