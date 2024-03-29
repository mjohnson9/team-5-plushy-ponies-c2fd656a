package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import com.levelup.forestsandmonsters.game.GameController;
import com.levelup.forestsandmonsters.game.GameStatus;
import com.levelup.forestsandmonsters.game.Position;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoveSteps {

    GameController testObj = new GameController();
    int startX, startY, endX, endY;
    GameController.DIRECTION direction;
    Position currentPosition;

    @Given("the character starts at position with XCoordinates {int}")
    public void givenTheCharacterStartsAtX(int startX) {
        this.startX = startX;
    }

    @Given("the character is named {word}")
    public void givenTheCharacterIsNamed(String name) {
        this.testObj.createCharacter(name);
    }

    @Given("the game is started")
    public void givenTheGameIsStarted() {
        this.testObj.startGame();
    }

    @Given("starts at YCoordinates {int}")
    public void givenTheCharacterStartsAtY(int startY) {
        this.startY = startY;
    }

    @Given("the player chooses to move in {word}")
    public void givenCharacterChoosesDirection(String direction) {
        this.direction = GameController.DIRECTION.valueOf(direction);
    }

    @Given("the current move count is {int}")
    public void givenTheCurrentMoveCountIs(int currentMoveCount) {
        testObj.setCurrentMoveCount(currentMoveCount);
    }

    @When("the character moves")
    public void theCharacterMoves() {
        testObj.setCharacterPosition(new Point(this.startX, this.startY));
        testObj.move(this.direction);
        GameStatus status = testObj.getStatus();
        this.currentPosition = status.currentPosition;
    }

    @Then("the character is now at position with XCoordinates {int}")
    public void checkXCoordinates(int endX) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endX, this.currentPosition.getX());
    }

    @Then("YCoordinates {int}")
    public void checkYCoordinates(int endY) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endY, this.currentPosition.getY());
    }

    @Then("the new move count is {int}")
    public void checkMoveCount(int endingMoveCount) {
        assertEquals(endingMoveCount, testObj.getStatus().moveCount);
    }

}
