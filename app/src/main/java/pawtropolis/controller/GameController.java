package pawtropolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.model.Player;

@Component
public class GameController {   //TODO è un component o un controller

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