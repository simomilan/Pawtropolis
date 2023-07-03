package model;

import zoo.Animal;

import java.util.*;

public class Room {

    private final String name;
    private final List<Item> items;
    private final List<Animal> animals;
    private final Map<Direction, Room> adjoiningRooms;

    public Room(String nameRoom) {
        this.name = nameRoom;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjoiningRooms = new EnumMap<>(Direction.class);

    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", adjoiningRooms=" + adjoiningRooms +
                '}';
    }

    public Room getAdjoiningDirectionRoom(Direction direction) {
        return adjoiningRooms.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;

    }

    public String getAllItems() {
        var sc = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            sc.append(items.get(i).getName());
            if (i < items.size() - 1) {
                sc.append(", ");
            }
        }


        return sc.toString();
    }


    public String getAllAnimals() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < animals.size(); i++) {
            sb.append(animals.get(i).getNickName());
            if (i < animals.size() - 1) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }


    public void addAdjoiningRoom(Direction direction, Room room) {
        adjoiningRooms.put(direction, room);
        room.adjoiningRooms.put(direction.opposite(), this);
    }

}