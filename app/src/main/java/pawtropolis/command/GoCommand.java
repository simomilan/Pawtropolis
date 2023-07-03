package pawtropolis.command;

import lombok.Setter;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Direction;
import pawtropolis.model.Room;
import pawtropolis.view.DirectionView;
import pawtropolis.view.RoomView;

@Component
@Setter
public class GoCommand implements GameCommand {

    private final GameController gameController;
    private  String direction;

    public GoCommand(GameController gameController) {
        this.gameController = gameController;
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
}