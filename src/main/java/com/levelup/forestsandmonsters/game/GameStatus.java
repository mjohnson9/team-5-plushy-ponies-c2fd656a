package com.levelup.forestsandmonsters.game;

import java.awt.Point;

public class GameStatus {
    public String characterName;
    public Point currentPosition;
    public int moveCount;

    public String toString() {
        return this.characterName + " gave up and quit " +
            "at " + this.currentPosition + " after " + this.moveCount + " " +
            "moves! Not enough for severance. :(";
    }
}
