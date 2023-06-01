package command;

import model.Direction;
import model.GameController;
import model.Room;

import java.util.List;

public class GoCommand implements GameCommand {

    private GameController gameController;
    private Direction direction;

    public GoCommand(GameController gameController, Direction direction) {
        this.gameController = gameController;
        this.direction = direction;
    }

    @Override
    public void execute() {
        Room currentRoom = gameController.getCurrentRoom();
        Room newRoom = currentRoom.getAdjoiningRooms().get(direction);
        if (newRoom != null) {
            gameController.setCurrentRoom(newRoom);
            System.out.println("You have entered the " + newRoom.getNameRoom());
        } else {
            System.out.println("There is no room in that direction.");
        }
    }
}