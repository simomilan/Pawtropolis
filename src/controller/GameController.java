package controller;


import model.Player;


public class GameController {

    private final Player player;
    private final MapController mapController;


    public GameController(Player player) {
        this.player = player;
        this.mapController = new MapController();
    }

    public Player getPlayer() {
        return player;
    }

    public MapController getMapController() {
        return mapController;
    }


}