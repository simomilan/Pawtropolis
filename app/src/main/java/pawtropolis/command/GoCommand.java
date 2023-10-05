package pawtropolis.command;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.model.Direction;
import pawtropolis.model.Room;

@Component
@Setter
public class GoCommand implements GameCommand {

    private final GameController gameController;
    private  String direction;

    @Autowired
    public GoCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        Direction dir = Direction.getDirectionFromString(direction);

        if (dir == null) {
            gameController.getViewFactory().getDirectionView().displayNotFoundDirection();
            return;
        }

        Room currentRoom = gameController.getMapController().getCurrentRoom();
        Room nextRoom = currentRoom.getAdjoiningDirectionRoom(dir);

        if (nextRoom != null) {
            gameController.getMapController().setCurrentRoom(nextRoom);
            gameController.getViewFactory().getDirectionView().displayNameCurrentRoom(nextRoom.getName());
            String items = gameController.getMapController().getCurrentRoom().getAllItemsDescription();
            String animals = gameController.getMapController().getCurrentRoom().getAllAnimalsDescription();
            if (items.isEmpty()) {
                gameController.getViewFactory().getRoomView().displayAbsenceItemInRoom();
            } else {
                gameController.getViewFactory().getRoomView().displayItemInRoom(items);
            }
            if (animals.isEmpty()) {
                gameController.getViewFactory().getRoomView().displayAbsenceAnimalInRoom();
            } else {
                gameController.getViewFactory().getRoomView().displayAnimalInRoom(animals);
            }
        }
        if (nextRoom == null) {
            gameController.getViewFactory().getDirectionView().displayNotFoundRoom();
        }
    }
}