package com.levelup.forestsandmonsters.game;

import java.awt.Point;

public class GameController {

    static final String DEFAULT_CHARACTER_NAME = "Character";

    public class GameStatus {
        // TODO: Add other status data
        public String characterName = DEFAULT_CHARACTER_NAME;
        public Point currentPosition = null;
        // TODO: Write a failing unit test that will force you to set this to the right
        // number
        public int moveCount = -100;
    }

    GameStatus status;
    Character character;
    GameMap map;
    int currentMoveCount = 0;

    public GameController() {
        status = new GameStatus();
    }

    public static enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    public void createCharacter(String name) {
        this.character = new Character(name);
        this.status.characterName = name;
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the
        // character
        // on them?
        // TODO: Should also update the game results?

        this.map = new GameMap();

    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void move(DIRECTION directionToMove) {
        this.character.move(directionToMove);
        currentMoveCount++;
    }

    public void setCharacterPosition(Point coordinates) {
        if (this.character == null) {
            throw new IllegalStateException("Cannot set character position for an unitialized character");
        }

        this.character.setPosition(new Position(coordinates.x, coordinates.y));
    }

    public void setCurrentMoveCount(int moveCount) {
        currentMoveCount = moveCount;
    }

    public int getCurrentMoveCount() {
        return currentMoveCount;
    }

    public int getTotalPositions() {
        return 100;
    }
}
