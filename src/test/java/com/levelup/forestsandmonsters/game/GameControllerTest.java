package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import com.levelup.forestsandmonsters.game.GameController;
import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

public class GameControllerTest {
    @Test
    public void initializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.status);
    }

    @Test
    public void characterMapIsInitialized() {
        GameController testObj = new GameController();
        testObj.createCharacter("test");
        testObj.startGame();
        testObj.move(DIRECTION.SOUTH);
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

    @Test
    public void startGameCreatesMap() {
        GameController testObj = new GameController();
        // character must be created to start a game
        testObj.createCharacter(GameController.DEFAULT_CHARACTER_NAME);
        testObj.startGame();
        assertNotNull(testObj.map);
        assertNotNull(testObj.map.getPositions());
    }

    @Test
    public void checkGameStatusMessageNotNull() {
        GameStatus status = new GameStatus();
        
        assertNotNull(status.toString());
    }

    @Test
    public void checkGameStatusMessageContainsVariables() {
        final String ARBITRARY_NAME = "JimBobJoeBat";
        final Position ARBITRARY_POSITION = new Position(7, 2);
        final int ARBITRARY_MOVE_COUNT = 108;

        GameStatus status = new GameStatus();
        status.characterName = ARBITRARY_NAME;
        status.currentPosition = ARBITRARY_POSITION;
        status.moveCount = ARBITRARY_MOVE_COUNT;

        final String statusString = status.toString();
        assertTrue(statusString.contains(ARBITRARY_NAME));
        assertTrue(statusString.contains(ARBITRARY_POSITION.toString()));
        assertTrue(statusString.contains(Integer.toString(ARBITRARY_MOVE_COUNT)));
    }

    @Test
    public void gameStatusNameMatchesCharacterName() {
        final String ARBITRARY_NAME = "aaaaaaaaaaaaaaaä";
        GameController testObj = new GameController();
        testObj.createCharacter(ARBITRARY_NAME);

        assertEquals(ARBITRARY_NAME, testObj.getStatus().characterName);
    }

    @Test
    public void moveCountUpdates() {
        GameController testObj = new GameController();
        testObj.createCharacter(GameController.DEFAULT_CHARACTER_NAME);
        testObj.startGame();

        int startMoveCount = testObj.getStatus().moveCount;
        testObj.move(DIRECTION.SOUTH);
        assertNotEquals(testObj.getStatus().moveCount, startMoveCount);
    }

    @Test
    public void moveUpdatesPosition() {
        GameController testObj = new GameController();
        testObj.createCharacter(GameController.DEFAULT_CHARACTER_NAME);
        testObj.startGame();

        Position startPosition = ((Position)testObj.getStatus().currentPosition.clone());
        testObj.move(DIRECTION.SOUTH);

        Position endPosition = testObj.getStatus().currentPosition;
        assertNotEquals(startPosition, endPosition);
    }
}
