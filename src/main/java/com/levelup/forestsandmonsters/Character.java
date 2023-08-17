package com.levelup.forestsandmonsters;

public class Character {
    static private String DEFAULT_NAME = "Character";

    private String name;

    public Character() {
        this.name = DEFAULT_NAME;
    }

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
