package command;

import model.Direction;
import controller.GameController;
import model.Room;
import view.DirectionView;
import view.RoomView;

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

            String items = gameController.getMapController().getCurrentRoom().getAllItems();
            String animals = gameController.getMapController().getCurrentRoom().getAllAnimals();


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


}