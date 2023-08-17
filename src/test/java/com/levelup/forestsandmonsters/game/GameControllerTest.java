package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.awt.Point;

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

    @Test
    public void setPositionHandlesUnitializedCharacter() {
        GameController testObj = new GameController();
        assertThrows(IllegalStateException.class, () -> testObj.setCharacterPosition(new Point()));
    }

    @Test
    public void setPositionHandlesResultsInReadable() {
        final Point ARTBIRARY_POS = new Point(5, 3);

        GameController testObj = new GameController();
        testObj.createCharacter(GameController.DEFAULT_CHARACTER_NAME);
        testObj.setCharacterPosition(ARTBIRARY_POS);

        Point characterPos = testObj.character.getPosition().point;
        assertEquals(characterPos.x, ARTBIRARY_POS.x);
        assertEquals(characterPos.y, ARTBIRARY_POS.y);
    }
}
