package pawtropolis.command;

import pawtropolis.controller.GameController;
import pawtropolis.view.RoomView;


public class LookCommand implements GameCommand {

    private final GameController gameController;

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

    public static void executeLookCommand(GameController gameController) {
        LookCommand lookCommand = new LookCommand(gameController);
        lookCommand.execute();
    }

}