package com.levelup.forestsandmonsters.game;

import java.awt.Point;

public class GameController {
    static final String DEFAULT_CHARACTER_NAME = "Character";

    public static class GameStatus {
        public String characterName = DEFAULT_CHARACTER_NAME;
        public Position currentPosition = null;
        public int moveCount = -100;

        public String toString() {
            return this.characterName + " gave up and quit " +
                "at cube [" + this.currentPosition + "] after " + this.moveCount + " " +
                "moves! Not enough for severance. :(";
        }
    }

    GameStatus status;
    Character character;
    GameMap map;

    public GameController() {
        status = new GameStatus();
    }

    public static enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    public void createCharacter() {
        this.createCharacter(DEFAULT_CHARACTER_NAME);
    }

    public void createCharacter(String name) {
        this.character = new Character(name);
        this.status.characterName = name;
        character.setPosition(new Position(5,5));
        this.status.currentPosition = this.character.getPosition();
        this.status.moveCount = 0;
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the
        // character
        // on them?
        // TODO: Should also update the game results?

        this.map = new GameMap();
        this.character.enterMap(this.map);
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void move(DIRECTION directionToMove) {
        this.character.move(directionToMove);
        
        this.status.moveCount += 1;
        this.status.currentPosition = this.character.getPosition();
    }

    public void setCharacterPosition(Point coordinates) {
        if (this.character == null) {
            throw new IllegalStateException("Cannot set character position for an unitialized character");
        }

        this.character.setPosition(new Position(coordinates.x, coordinates.y));
    }

    public void setCurrentMoveCount(int moveCount) {
        this.status.moveCount = moveCount;
    }

    public int getCurrentMoveCount() {
        return this.status.moveCount;
    }

    public int getTotalPositions() {
        return 100;
    }
}
