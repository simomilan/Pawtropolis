package pawtropolis.src.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pawtropolis.src.controller.TextGame;
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        TextGame game = new TextGame();
        game.start();

    }
}


