package command;

import controller.GameController;
import view.RoomView;

public class LookCommand implements GameCommand {

    private final GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        RoomView roomView = new RoomView();

        String roomName = gameController.getMapController().getCurrentRoom().getName();
        String items = gameController.getMapController().getCurrentRoom().getAllItems();
        String animals = gameController.getMapController().getCurrentRoom().getAllAnimals();

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