package command;

import controller.GameController;
import model.Item;
import java.util.List;
import java.util.Scanner;

public class DropCommand implements GameCommand {

    private GameController gameController;
    private String itemName;



    public DropCommand(GameController gameController, String itemName) {
        this.gameController = gameController;
        this.itemName=itemName;


    }

    public void execute() {
        List <Item> items = gameController.getPlayer().getBag().getItems();
        Scanner scanner = new Scanner(System.in);

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
            return;
        }



        Item selectedItem = null;
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                selectedItem = item;
                break;
            }
        }                                                                   // fatto!       //l aggiunta dell'iem (o rimozione nell' addCommand) lo deve farew
        if (selectedItem != null) {                                 //fatto!           //il metodo execute e non il dropItemFromBag sennò se chiamava
            gameController.getPlayer().giveItemByName(selectedItem);//dropItemFromBag&GetToRoom
      gameController.getMapController().getCurrentRoom().addItem(selectedItem);
            System.out.println("\nThe item has been dropped from the bag: " + selectedItem.getName());
            System.out.println((selectedItem.getName() + " has been added in  the room"));
            System.out.print(("Now the available space in your bag is: " + gameController.getPlayer().getBag().getAvailableSpace() ));
        } else {                                                                                                            //ghahhahahahah
            System.out.println("\nItem not found in your bag: " + itemName);
        }
    }
}

            //fatto!                //deve essere tipo: gameController.GetPlayer.GetItemByName e stop

                            //In drop siamo stati inconsistenti, ma jche ver dì?!o