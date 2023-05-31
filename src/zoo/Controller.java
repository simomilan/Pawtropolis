package zoo;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Controller {

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public static final String LION = "lion";
    private static final String TIGER = "tiger";
    private static final String EAGLE = "eagle";


    public static void main(String[] args)  {



        Zoo zoo = new Zoo();

        LocalDate l1 = LocalDate.of(2020, 1, 1);
        LocalDate l2 = LocalDate.of(2021, 2, 2);
        LocalDate l3 = LocalDate.of(2017, 3, 3);

        zoo.addAnimal(LION, new Lion("Simba", "Meat", 4, l1, 320.00, 120.00, 90.00));
        zoo.addAnimal(LION, new Lion("Luca", "Meat", 2, l2, 270.00, 115.00, 83.00));
        zoo.addAnimal(LION, new Lion("Gio", "Meat", 7, l3, 325.00, 122.00, 94.00));

        LocalDate t1 = LocalDate.of(2021, 4, 2);
        LocalDate t2 = LocalDate.of(2019,9,10);
        LocalDate t3 = LocalDate.of(2016,8, 12);

        zoo.addAnimal(TIGER, new Tiger("Gatto", "Meat", 3, t1, 288.00, 116.00, 100.00));
        zoo.addAnimal(TIGER, new Tiger("Gino", "Meat", 6, t2, 301.00, 123.00, 102.00));
        zoo.addAnimal(TIGER, new Tiger("Pippo", "Meat", 9, t3, 309.00, 125.00, 109.00));

        LocalDate e1 = LocalDate.of(2022, 7,19);
        LocalDate e2 = LocalDate.of(2018, 3,12);
        LocalDate e3 = LocalDate.of(2020, 7,9);

        zoo.addAnimal(EAGLE, new Eagle("Lello", "Meat", 1, e1, 40.00, 50.00, 130.00));
        zoo.addAnimal(EAGLE, new Eagle("Titti", "Meat", 5, e2, 75.00, 90.00, 191.00));
        zoo.addAnimal(EAGLE, new Eagle("Ciccio", "Meat", 3, e3, 73.00, 88.00, 187.00));



        Animal tallestLion = zoo.findTallest(LION);
        LOGGER.info("Tallest lion: " + tallestLion.getNickName() + " with an height of " + tallestLion.getHeight() + " cm ");

        Animal shortestTiger = zoo.findShortest(TIGER);
        LOGGER.info("Shortest tiger: " + shortestTiger.getNickName() + " with an height of " + shortestTiger.getHeight() + " cm ");

        Animal heaviestEagle = zoo.findHeaviest(EAGLE);
        LOGGER.info("Heaviest eagle: " + heaviestEagle.getNickName() + " with a weight  of " + heaviestEagle.getHeight() + " Kg ");

        Animal lightestLion = zoo.findLightest(LION);
        LOGGER.info("Lightest lion: " + lightestLion.getNickName() + " with a weight of " + lightestLion.getWeight() + " Kg ");

        Animal longestTail = zoo.findLongestTail();
        LOGGER.info("Animal with longest tail: " + longestTail.getNickName() + " of the species " + longestTail.getClass().getSimpleName() + " with a length of " + ((Tailed) longestTail).getTailLength());

        Animal largestWingspan = zoo.findLargestWingspan();
        LOGGER.info("Animal with largest wingspan: " + largestWingspan.getNickName() + " of the species " + largestWingspan.getClass().getSimpleName() + " with a largeness of " + ((Winged) largestWingspan).getWingspan());


    }

}


