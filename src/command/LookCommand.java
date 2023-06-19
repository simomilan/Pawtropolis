package command;

import controller.GameController;
import model.Item;
import zoo.Animal;

import java.util.List;

public class LookCommand implements GameCommand {

    private GameController gameController;

    public LookCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute () {

        System.out.println('\n' + "You are in " + gameController.getMapController().getCurrentRoom().getNameRoom());
        List<Item> items = gameController.getMapController().getCurrentRoom().getItemsInRoom();

        if (items.isEmpty()) {
            System.out.print("There are no items in the room");
        } else {
            System.out.print("Items in the room: ");

            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).name());
                if (i < items.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        List<Animal> animals = gameController.getMapController().getCurrentRoom().getAnimalsInRoom();

        if (animals.isEmpty()) {
            System.out.print("\nThere are no Animals in the room");
        } else {
            System.out.print("\nAnimals in the room: ");
            for (int i = 0; i < animals.size(); i++) {
                System.out.print(animals.get(i).getNickName() + " (" + animals.get(i).getClass().getSimpleName() + ") " );
                if (i < animals.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}