package controller;

import model.Direction;
import model.Player;
import model.Room;

public class GameController {

    private Player player;
    private MapController mapController;


    public GameController(Player player, MapController mapController) {
        this.player = player;
        this.mapController = new MapController(mapController.getCurrentRoom());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        this.player = player;
    }
    public MapController getMapController() {
        return mapController;
    }

    public void setMapController(MapController mapController) {
        this.mapController = mapController;
    }

    public Room changeRoom(Direction direction){
        return mapController.getCurrentRoom().getDirectionRoom(direction);
    }
}
