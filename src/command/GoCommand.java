package command;

import model.Direction;
import model.GameController;
import model.Room;

public class GoCommand implements GameCommand {

    private GameController gameController;
    private Direction direction;

    public GoCommand(GameController gameController, Direction direction) {
        this.gameController = gameController;
        this.direction = direction;
    }

    @Override
    public void execute() {
        Room currentRoom =  gameController.getPlayer().getCurrentRoom();
        Room newRoom = currentRoom.getDirectionRoom(direction);
        if (newRoom != null) {
            gameController.getPlayer().setCurrentRoom(newRoom);
            System.out.println("\nYou have entered in " + newRoom.getNameRoom());
        } else {
            System.out.println("\nThere is no room in that direction");
        }
    }
}