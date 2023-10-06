package pawtropolis.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.model.Player;
import pawtropolis.view.*;

@Component
@Getter
@Setter
public class GameController {

    private final Player player;
    private final MapController mapController;
    private boolean gameRunning;
    private final ViewFactory viewFactory;

    @Autowired
    public GameController(Player player, ViewFactory viewFactoryParam) {
        this.player = player;
        this.mapController = new MapController();
        this.gameRunning = true;
        viewFactory = viewFactoryParam;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void endGame() {
        gameRunning = false;
    }

}
