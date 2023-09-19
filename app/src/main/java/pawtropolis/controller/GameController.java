package pawtropolis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pawtropolis.model.Player;

@Controller
public class GameController {

    private final Player player;
    private final MapController mapController;
    private boolean gameRunning;

    @Autowired
    public GameController(Player player) {
        this.player = player;
        this.mapController = new MapController();
        this.gameRunning = true;
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void endGame() {
        gameRunning = false;
    }

}