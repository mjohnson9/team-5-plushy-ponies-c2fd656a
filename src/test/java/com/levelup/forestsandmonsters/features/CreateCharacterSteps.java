package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.game.GameController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCharacterSteps {

    GameController gc;
    String characterName = null;

    @Given("player supplies the name {string}")
    public void givenTheCharactersNameIs(String characterName) {
        if(characterName.isEmpty()) {
            this.characterName = null;
            return;
        }

        this.characterName = characterName;
    }

    @When("the character is created")
    public void whenTheCharacterSetsTheirName() {
        gc = new GameController();

        if (this.characterName != null) {
            gc.createCharacter(characterName);
        } else {
            gc.createCharacter();
        }
    }

    @Then("the Game sets the character name to {string}")
    public void thenTheGameSetsTheCharactersName(String expectedName) {
        assertEquals(expectedName, gc.getStatus().characterName);
    }
}
