package com.levelup.forestsandmonsters.game;

import com.levelup.forestsandmonsters.game.GameMap;

public class CharacterFake extends Character {
    public CharacterFake (){}
    public CharacterFake (Position position ) {
        this.setPosition(position);

    }

    public GameMap getMap() {
        return this.map;
    }
}
