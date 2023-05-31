package command;

import model.GameController;
import model.Room;

public class LookCommand implements GameCommand {

    private GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        Room currentRoom = gameController.getPlayer().getCurrentRoom();
        System.out.println("Current room: " + currentRoom.getNameRoom());
        System.out.println("Items in the room: " + currentRoom.getItemsInRoom());
        System.out.println("Animals in the room: " + currentRoom.getAnimalsInRoom());

    }
}
