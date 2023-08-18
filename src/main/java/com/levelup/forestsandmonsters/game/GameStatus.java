package com.levelup.forestsandmonsters.game;

public class GameStatus {
    public String characterName = GameController.DEFAULT_CHARACTER_NAME;
    public Position currentPosition = null;
    public int moveCount = -100;

    public String toString() {
        return this.characterName + " Moved to " +
            "cube [" + this.currentPosition + "] after " + this.moveCount + " moves.";
    }
}