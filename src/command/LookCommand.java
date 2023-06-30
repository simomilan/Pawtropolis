package command;

import controller.GameController;

public class LookCommand implements GameCommand {

    private final GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {


        String roomName = gameController.getMapController().getCurrentRoom().getName();
        String items = gameController.getMapController().getCurrentRoom().getAllItems();
        String animals = gameController.getMapController().getCurrentRoom().getAllAnimals();

        System.out.println(roomName);
        System.out.println(items);
        System.out.println(animals);
    }
}