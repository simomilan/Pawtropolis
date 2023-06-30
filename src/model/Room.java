package model;

import zoo.Animal;

import java.util.*;

public class Room {

    private final String name;
    private final List <Item> items;
    private final List<Animal> animals;
    private final  Map <Direction, Room> adjoiningRooms;

    public Room(String nameRoom)  {
        this.name = nameRoom;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjoiningRooms = new EnumMap <>(Direction.class);

    }
    public String getName () {
        return name;
    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" +name+ '\'' +
                ", adjoiningRooms=" + adjoiningRooms +
                '}';
    }

    public void addAdjoiningRoom( Direction direction, Room room) {  //aggiunge la stanza alla lista
        adjoiningRooms.put(direction, room);
    }

    public Room getAdjoiningDirectionRoom (Direction direction) {
        return adjoiningRooms.get(direction);
    }

    public void addItem (Item item){
        items.add(item);
    }

    public void addAnimal (Animal animal){
        animals.add(animal);
    }

    public void removeAnimal (Animal animal) {
        animals.remove(animal);
    }
    public void removeItem (Item item) {
        items.remove(item);
    }



    /////NON VA BENE DA TOGLIERE POICHè PER MODIFICARE LISTA PUOI AGGIUNGERE CON METODO ADDIREM, REMOVEITEM, USARE METODO ITEMBYNAME problema di bag-player
    /*public List<Item> getItemsInRoom() {
        return new ArrayList<>(items);
    } NON VA BENE PERCHè CREI UNA COPIA DEL GETITEMSINROOM ATTRAVERSO L'ARRAYLIST */
    /////NON VA BENE DA TOGLIERE POICHè PER MODIFICARE LISTA PUOI AGGIUNGERE CON METODO ADDIREM, REMOVEITEM, USARE METODO ITEMBYNAME

//Usato in ADDcommand
    public Item getItemByName(String itemName){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;

    }

/*Implementazione della logica di business nel modello, che può essere richiamata
dal controller per ottenere i dati necessari da visualizzare nella vista. Usato in LOOKCommand, funziona*/
    public String getAllItems() {
        StringBuilder sb = new StringBuilder();

        if (items.isEmpty()) {
            sb.append("There are no items in the room");
        } else {
            sb.append("Items in the room: ");

            for (int i = 0; i < items.size(); i++) {
                sb.append(items.get(i).getName());
                if (i < items.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }


    public String getAllAnimals() {
        StringBuilder sb = new StringBuilder();

        if (animals.isEmpty()) {
            sb.append("There are no animal in the room");
        } else {
            sb.append("Animal in the room: ");

            for (int i = 0; i < animals.size(); i++) {
                sb.append(animals.get(i).getNickName());
                if (i < animals.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }


    public Animal getAnimalByName(String nickName){
        for (Animal animal: animals) {
            if (animal.getNickName().equalsIgnoreCase(nickName)) {
                return animal;
            }
        }
        return null;

    }

}