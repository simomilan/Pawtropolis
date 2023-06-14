package command;

import model.Direction;
import controller.GameController;
import model.Room;

import java.util.Scanner;

public class GoCommand implements GameCommand {

    private GameController gameController;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Direction direction;
        if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("north")) {
            direction = Direction.NORTH;
        } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("south")) {
            direction = Direction.SOUTH;
        } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("east")) {
            direction = Direction.EAST;
        } else if (input.trim().replaceAll("\\s+", "").equalsIgnoreCase("west")) {
            direction = Direction.WEST;
        } else {
            System.out.println("Invalid direction. Choose a valid direction : north, south, east, west");
            return;
        }
        Room currentRoom =  gameController.getMapController().getCurrentRoom();
        Room newRoom = currentRoom.getDirectionRoom(direction);
        if (newRoom != null) {
            gameController.getMapController().setCurrentRoom(newRoom);
            System.out.println("\nYou have entered in " + newRoom.getNameRoom());

            LookCommand lookCommand = new LookCommand(gameController);
            lookCommand.execute();
        } else {
            System.out.println("\nThere is no room in that direction");
        }
    }
}