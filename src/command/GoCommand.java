package command;

import model.Direction;
import controller.GameController;
import model.Room;

public class GoCommand implements GameCommand {

    private final GameController gameController;
    private final String direction;

    public GoCommand(GameController gameController, String direction) {
        this.gameController = gameController;
        this.direction= direction;
    }

    @Override
    public void execute() {


        Direction dir = Direction.getDirectionFromString(direction);

        if (dir == null) {
            System.out.println("\nInvalid direction. Choose a valid direction: north, south, east, west");
            return;
        }

        Room currentRoom = gameController.getMapController().getCurrentRoom();
        Room newRoom = currentRoom.getAdjoiningDirectionRoom(dir);

        if (newRoom != null) {
            gameController.getMapController().setCurrentRoom(newRoom);
            System.out.println("\nYou have entered " + newRoom.getName());

            LookCommand lookCommand = new LookCommand(gameController);
            lookCommand.execute();
        } else {
            System.out.println("\nThere is no room in that direction");
        }
    }


}