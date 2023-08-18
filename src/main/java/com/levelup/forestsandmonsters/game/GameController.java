package com.levelup.forestsandmonsters.game;

import java.awt.Point;

public class GameController {
    static final String DEFAULT_CHARACTER_NAME = "Character";

    GameStatus status;
    Character character;
    GameMap map;
    public Boolean isGameStarted = false;

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
        if(this.character == null) {
            throw new IllegalStateException("The character must be created before the game can start.");
        } else {
        this.map = new GameMap();
        this.character.enterMap(this.map);
        this.isGameStarted = true;
        }

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
            throw new IllegalStateException("Cannot set character position for an uninitialized character");
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
