package command;

import controller.GameController;
import model.Item;
import java.util.List;
import java.util.Scanner;

public class DropCommand implements GameCommand {

    private GameController gameController;



    public DropCommand(GameController gameController) {
        this.gameController = gameController;


    }

    public void execute() {
        List <Item> items = gameController.getPlayer().getBag().getItems();
        Scanner scanner = new Scanner(System.in);

        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");
            return;
        }

        System.out.print("\nEnter the name of the item to drop: ");
        String itemName = scanner.nextLine();
        itemName = itemName.trim().replaceAll("\\s+", "");       //repleceall ovviamnete non va bene perche se la stringa è composta
                                                                              // da più parole me la fonde in una parolona unica
                                                                              //già sapevamo che gli input andavano gestiti diversamente
        Item selectedItem = null;
        for (Item item : items) {
            if (item.name().equalsIgnoreCase(itemName)) {
                selectedItem = item;
                break;
            }
        }                                                                   // fatto!       //l aggiunta dell'iem (o rimozione nell' addCommand) lo deve farew
        if (selectedItem != null) {                                 //fatto!           //il metodo execute e non il dropItemFromBag sennò se chiamava
            gameController.getPlayer().giveItemByName(selectedItem);//dropItemFromBag&GetToRoom
      gameController.getMapController().getCurrentRoom().addItem(selectedItem);
        } else {                                                                                                            //ghahhahahahah
            System.out.println("\nItem not found in your bag: " + itemName);
        }
    }
}

            //fatto!                //deve essere tipo: gameController.GetPlayer.GetItemByName e stop

                            //In drop siamo stati inconsistenti, ma jche ver dì?!o