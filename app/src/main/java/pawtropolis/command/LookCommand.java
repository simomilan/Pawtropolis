package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.view.RoomView;

@Component
public class LookCommand implements GameCommand {

    private final GameController gameController;
@Autowired
    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        RoomView roomView = new RoomView();

        String roomName = gameController.getMapController().getCurrentRoom().getName();
        String items = gameController.getMapController().getCurrentRoom().getAllItemsDescription();
        String animals = gameController.getMapController().getCurrentRoom().getAllAnimalsDescription();

        roomView.displayNameRoom(roomName);
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
}