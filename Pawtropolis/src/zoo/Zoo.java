package zoo;

import java.util.*;

public class Zoo {

    private final Map <String, List <Animal>> animals;

    public Zoo() {
        animals = new HashMap <>();
    }

    public void addAnimal(String species, Animal animal) {
        List<Animal> animalList = animals.getOrDefault(species, new ArrayList <>());
        animalList.add(animal);
        animals.put(species, animalList);
    }

    public Animal findTallest(String species) {
        return animals.getOrDefault(species, Collections.emptyList())
                .stream()
                .max(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);
    }

    public Animal findShortest(String species) {
        return animals.getOrDefault(species, Collections.emptyList())
                .stream()
                .min(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);
    }

    public Animal findHeaviest(String species) {
        return animals.getOrDefault(species, Collections.emptyList())
                .stream()
                .max(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);
    }

    public Animal findLightest(String species) {
        return animals.getOrDefault(species, Collections.emptyList())
                .stream()
                .min(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);
    }

    public Animal findLongestTail() {
        return animals.values().stream()
                .flatMap(List::stream)
                .filter(Tailed.class::isInstance)
                .map(Tailed.class::cast)
                .max(Comparator.comparingDouble(Tailed::getTailLength))
                .orElse(null);
    }

    public Animal findLargestWingspan() {
        return animals.values().stream()
                .flatMap(List::stream)
                .filter(Winged.class::isInstance)
                .map(Winged.class::cast)
                .max(Comparator.comparingDouble(Winged::getWingspan))
                .orElse(null);
    }
}