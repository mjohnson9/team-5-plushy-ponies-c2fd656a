package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class CharacterTest {
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
}
