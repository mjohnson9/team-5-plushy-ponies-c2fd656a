package com.levelup.forestsandmonsters.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import com.levelup.forestsandmonsters.game.Position;

import com.levelup.forestsandmonsters.game.GameController.DIRECTION;

public class CharacterTest {
    @Test
    public void characterMoveIsNotImplemented() {
        Character testObj = new Character();
        GameMap map = new GameMap();
        testObj.enterMap(map);
        Position pos = new Position(0,0);
        testObj.setPosition(pos);
        assertNotNull(testObj);
        testObj.move(DIRECTION.SOUTH);
       // assertEquals(testObj.getPosition().getX(), 0);
        assertEquals(testObj.getPosition().getY(), 1);
    }

    @Test
    public void emptyConstructorExists() {
        Character testObj = new Character();
        assertNotNull(testObj);
    }

    @Test
    public void nameConstructorWorks() {
        final String ARBITRARY_CHARACTER_NAME = "Emily";
        Character testObj = new Character(ARBITRARY_CHARACTER_NAME);
        assertEquals(ARBITRARY_CHARACTER_NAME, testObj.getName());
    }

    @Test
    public void characterCanEnterMap() {
        GameMap fakeMap = new GameMapFake();
        CharacterFake testObj = new CharacterFake();
        testObj.enterMap(fakeMap);
        assertEquals(testObj.getMap(), fakeMap);
    }

    @Test
    public void characterCanGetPosition() {
        CharacterFake testObj = new CharacterFake();
        assertNotNull(testObj.getPosition());
    }

    @Test
    public void characterCanGetPositionIsConsistent() {
        Position fakePosition = new Position(5, 5);
        CharacterFake testObj = new CharacterFake(fakePosition);
        assertEquals(testObj.getPosition(), fakePosition);
    }
}
