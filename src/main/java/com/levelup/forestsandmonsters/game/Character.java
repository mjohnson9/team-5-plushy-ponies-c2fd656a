package com.levelup.forestsandmonsters.game;

import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

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

    public void move(DIRECTION direction) {

        Position pos= getPosition();
        Position posnew=null;
        switch (direction){
           case NORTH:
                 posnew = new  Position(pos.getX(),Math.max(pos.getY()-1,0));
                setPosition(posnew);
                break;
           case SOUTH:
                 posnew = new  Position(pos.getX(),Math.min(pos.getY()+1,9));
                setPosition(posnew);
                break;
           case EAST:
                posnew = new  Position(Math.min(pos.getX()+1,9),pos.getY());
                setPosition(posnew);
                break;
           case WEST:
                posnew = new  Position(Math.max(pos.getX()-1,0),pos.getY());
                setPosition(posnew);
                break;
            default :
                break;

        }
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
