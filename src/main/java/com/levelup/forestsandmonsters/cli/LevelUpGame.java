package com.levelup.forestsandmonsters.cli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.commands.Quit;

import com.levelup.forestsandmonsters.game.GameController;
import com.levelup.forestsandmonsters.game.GameStatus;

@ShellComponent
public class LevelUpGame implements Quit.Command {

  private final GameController gameController;
  private List<GameStatus> gameHistory;
  private boolean isGameStarted = false;

  public LevelUpGame() {
    super();
    this.gameController = new GameController();
    this.gameHistory = new ArrayList<GameStatus>();
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod(value = "Create a character (characterName)", key = { "create-character", "create" })
  public void createCharacter(@ShellOption(defaultValue = "Character") String characterName) {
    gameController.createCharacter(characterName);
    GameStatus status = gameController.getStatus();
    int resourceNum = (int)(Math.random()*1000000) ;

    System.out.println("Greetings Resource " + resourceNum + " (" + status.characterName + ") You have awoken in the  C.I.C. Can you survive and escape?");
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod("Start the game")
  public void startGame() {
    isGameStarted = true;
    gameController.startGame();
    // TODO: Update this prompt. Also, do you want to get the game status and tell
    // the character where their character is?
    System.out.println("You are in a gray cube farm, how do you proceed?");
    System.out.println("Would you like to go North(N), South(S), East(E), West(W) or Exit(X)?");
  }

  @ShellMethod(value = "Move North", key = { "N", "n" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveNorth() {
    gameController.move(GameController.DIRECTION.NORTH);
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move South", key = { "S", "s" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveSouth() {
    gameController.move(GameController.DIRECTION.SOUTH);
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move East", key = { "E", "e" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveEast() {
    gameController.move(GameController.DIRECTION.EAST);
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move West", key = { "W", "w" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveWest() {
    gameController.move(GameController.DIRECTION.WEST);
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "End the game", key = { "X", "x" })
  public void endGame() {
    System.out.println("You exit the C.I.C.");
    printSummary();
    System.exit(0);
  }

  private void printSummary() {
  String characterName = "";
    for (GameStatus status : gameHistory) {
      // TODO: Override toString on game status to print pretty
      System.out.println(status);
      characterName = status.characterName;
    }
    System.out.println(characterName + " gave up and quit, Not long enough for Severence.");
    // TODO: Print anything else you committed to in your mockup
  }

  private void updateStatus(GameStatus status) {
    GameStatus temp = new GameStatus();
    temp.characterName = status.characterName;
    temp.currentPosition = status.currentPosition;
    temp.moveCount = status.moveCount;
    this.gameHistory.add(temp);
  }

  public Availability startedCheck() {
    return isGameStarted
        ? Availability.available()
        : Availability.unavailable("game not started");
  }

  public Availability notStartedCheck() {
    return !isGameStarted
        ? Availability.available()
        : Availability.unavailable("game already started");
  }

}
