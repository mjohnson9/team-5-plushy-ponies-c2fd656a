package com.levelup.forestsandmonsters.game;

public class Character {
    static private String DEFAULT_NAME = "Character";

    private String name;
    GameMap map;
    private Position position;

    public Character() {
        this.name = DEFAULT_NAME;
        this.position = new Position();
    }

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void enterMap(GameMap map) {
        this.map = map;
    }

    public GameMap getMap() {
        return this.map;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;

    }

}
