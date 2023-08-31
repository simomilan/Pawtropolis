package pawtropolis.src.command;

import pawtropolis.src.controller.InputController;
import pawtropolis.src.controller.GameController;
import pawtropolis.src.model.Direction;
import pawtropolis.src.model.Room;
import pawtropolis.src.view.ConsoleView;
import pawtropolis.src.view.DirectionView;
import pawtropolis.src.view.RoomView;


public class GoCommand implements GameCommand {

    private final GameController gameController;
    private final String direction;

    public GoCommand(GameController gameController, String direction) {
        this.gameController = gameController;
        this.direction = direction;

    }

    @Override
    public void execute() {
        DirectionView directionView = new DirectionView();
        RoomView roomView = new RoomView();
        Direction dir = Direction.getDirectionFromString(direction);

        if (dir == null) {
            directionView.displayNotFoundDirection();
            return;
        }

        Room currentRoom = gameController.getMapController().getCurrentRoom();
        Room nextRoom = currentRoom.getAdjoiningDirectionRoom(dir);

        if (nextRoom != null) {
            gameController.getMapController().setCurrentRoom(nextRoom);
            directionView.displayNameCurrentRoom(nextRoom.getName());

            String items = gameController.getMapController().getCurrentRoom().getAllItemsDescription();
            String animals = gameController.getMapController().getCurrentRoom().getAllAnimalsDescription();

            if (items.isEmpty()) {
                roomView.displayAbsenceItemInRoom();
            } else {
                roomView.displayItemInRoom(items);
            }

            if (animals.isEmpty()) {
                roomView.displayAbsenceAnimalInRoom();
            } else {
                roomView.displayAnimalInRoom(animals);
            }
        }
        if (nextRoom == null) {
            directionView.displayNotFoundRoom();
        }
    }


    public static void executeGoCommand(GameController gameController, String secondPart) {
        ConsoleView consoleView = new ConsoleView();

        try {
            String direction = InputController.cleanerInputMultipleWord(secondPart.split(" +")[1]);
            GameCommand goCommand = new GoCommand(gameController, direction);
            goCommand.execute();

        } catch (ArrayIndexOutOfBoundsException e) {
            consoleView.displayInvalidDirection();
        }
    }


}