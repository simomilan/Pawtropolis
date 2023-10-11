package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;

@Component
public class LookCommand implements GameCommand {

    private final GameController gameController;

    @Autowired
    private LookCommand(GameController gameControllerParam) {
        gameController = gameControllerParam;
    }

    @Override
    public void execute() {
        String roomName = gameController.getMapController().getCurrentRoom().getName();
        String items = gameController.getMapController().getCurrentRoom().getAllItemsDescription();
        String animals = gameController.getMapController().getCurrentRoom().getAllAnimalsDescription();
        gameController.getViewFactory().getRoomView().displayNameRoom(roomName);
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
}