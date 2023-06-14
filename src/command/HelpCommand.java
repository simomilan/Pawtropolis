package command;

import controller.GameController;

public class HelpCommand {

    private GameController gameController;

    public HelpCommand(GameController gameController) {
        this.gameController = gameController;
    }

    public void execute(){
        System.out.println("Available command:");
        System.out.println("- help: displays the list of command");
        System.out.println("- look: examine the current room");
        System.out.println("- go: choose a direction to change room (north, south, east, west)");
        System.out.println("- get: pick up the select item and add it to the bag ");
        System.out.println("- drop: take the item out of the bag and leave it in the room");
        System.out.println("- showBag: displays the items in your bag ");
        System.out.println("- quit: quit the game");
    }
}