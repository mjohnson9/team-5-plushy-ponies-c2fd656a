package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.game.GameController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StartGameSteps {

    GameController testObj;

    @When("the game is started with a character named {word}")
    public void whenTheCharacterSetsTheirName(String name) {
        testObj = new GameController();
        testObj.createCharacter(name);
        testObj.startGame();
    }

    @Then("the Game has {int} positions")
    public void thenTheGameSetsTheCharactersName(int numPositions) {
        assertEquals(numPositions, testObj.getTotalPositions());
    }

    @Then("the Game sets the character's X position to {int}")
    public void checkXPosition(int xPosition)
    {
        assertEquals(xPosition, testObj.getStatus().currentPosition.getX());
    }

    @Then("the Game sets the character's Y position to {int}")
    public void checkYPosition(int yPosition) 
    {
        assertEquals(yPosition, testObj.getStatus().currentPosition.getY());
    }

    @Then("the move count is {int}")
    public void checkMoveCount(int moveCount) 
    {
        assertEquals(moveCount, testObj.getStatus().moveCount);
    }

}
