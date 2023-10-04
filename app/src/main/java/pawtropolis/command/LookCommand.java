package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;

@Component
public class LookCommand implements GameCommand {

    private final GameController gameController;

    @Autowired
    public LookCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        String roomName = gameController.getMapController().getCurrentRoom().getName();
        String items = gameController.getMapController().getCurrentRoom().getAllItemsDescription();
        String animals = gameController.getMapController().getCurrentRoom().getAllAnimalsDescription();
        gameController.getRoomView().displayNameRoom(roomName);
        if (items.isEmpty()) {
            gameController.getRoomView().displayAbsenceItemInRoom();
        } else {
            gameController.getRoomView().displayItemInRoom(items);
        }
        if (animals.isEmpty()) {
            gameController.getRoomView().displayAbsenceAnimalInRoom();
        } else {
            gameController.getRoomView().displayAnimalInRoom(animals);
        }
    }
}