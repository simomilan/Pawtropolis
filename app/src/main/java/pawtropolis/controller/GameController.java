package pawtropolis.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.model.Player;
import pawtropolis.view.BagView;
import pawtropolis.view.ConsoleView;
import pawtropolis.view.DirectionView;
import pawtropolis.view.RoomView;

@Component
@Getter
@Setter
public class GameController {

    private final Player player;
    private final MapController mapController;
    private boolean gameRunning;
    private BagView bagView;
    private ConsoleView consoleView;
    private DirectionView directionView;
    private RoomView roomView;
    @Autowired
    public GameController(Player player, BagView bagViewParam, ConsoleView consoleViewParam,
                          DirectionView directionViewParam, RoomView roomViewParam) {
        this.player = player;
        this.mapController = new MapController();
        this.gameRunning = true;
        bagView = bagViewParam;
        consoleView = consoleViewParam;
        directionView = directionViewParam;
        roomView = roomViewParam;
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
