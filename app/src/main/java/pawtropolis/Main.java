package pawtropolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawtropolis.controller.TextGame;
import pawtropolis.model.Bag;
import pawtropolis.model.Player;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        TextGame game = new TextGame(new Player(new Bag()));
        game.start();

    }
}


