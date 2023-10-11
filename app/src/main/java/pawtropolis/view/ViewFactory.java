package pawtropolis.view;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ViewFactory {

    private final BagView bagView;
    private final ConsoleView consoleView;
    private final DirectionView directionView;
    private final RoomView roomView;

    @Autowired
    private ViewFactory(BagView bagView, ConsoleView consoleView, DirectionView directionView, RoomView roomView) {
        this.bagView = bagView;
        this.consoleView = consoleView;
        this.directionView = directionView;
        this.roomView = roomView;
    }

}
