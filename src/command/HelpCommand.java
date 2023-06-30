package command;


public class HelpCommand implements GameCommand {

    @Override
    public void execute(){
        System.out.println("\nAvailable command:");
        System.out.println("- help: displays the list of command");
        System.out.println("- look: examine the current room");
        System.out.println("- go: choose a direction to change room (north, south, east, west). Example: go north");
        System.out.println("- get: pick up the select item and add it to the bag. Example: get + collar ");
        System.out.println("- drop: take the item out of the bag and leave it in the room. Example: drop collar");
        System.out.println("- showBag: displays the items in your bag ");
        System.out.println("- quit: quit the game");
    }
}