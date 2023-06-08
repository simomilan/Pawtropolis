package command;

import model.GameController;
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

        System.out.println('\n' + "You are in " + gameController.getPlayer().getCurrentRoom().getNameRoom());
        List<Item> items = gameController.getItems(gameController.getPlayer().getCurrentRoom());

        if (items.isEmpty()) {
            System.out.println("There are no items in the room");
        } else {
            System.out.print("Items in the room: ");

            for (int i = 0; i < items.size(); i++) {
                System.out.print(items.get(i).getNameItem());
                if (i < items.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        List<Animal> animals = gameController.getAnimals(gameController.getPlayer().getCurrentRoom());

        if (animals.isEmpty()) {
            System.out.print("\nThere are no Animals in the room.");
        } else {
            System.out.print("\nAnimals in the room: ");
            for (int i = 0; i < animals.size(); i++) {
                System.out.print(animals.get(i).getNickName());
                if (i < animals.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}