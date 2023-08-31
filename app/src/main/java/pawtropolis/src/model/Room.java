package pawtropolis.src.model;

import lombok.Getter;
import lombok.ToString;
import pawtropolis.src.zoo.Animal;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
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
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);

    }

    public String getAllItemsDescription() {
        return items.stream()
                .map(Item::getName)
                .collect(Collectors.joining(", "));
    }


    public String getAllAnimalsDescription() {
        return animals.stream()
                .map(Animal::getNickName)
                .collect(Collectors.joining(", "));
    }


    public void addAdjoiningRoom(Direction direction, Room room) {
        adjoiningRooms.put(direction, room);
        room.adjoiningRooms.put(direction.opposite(), this);
    }

}