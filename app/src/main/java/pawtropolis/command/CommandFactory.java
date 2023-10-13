package pawtropolis.command;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.controller.InputController;


@Component
@Getter
public class CommandFactory {

    private final GameController gameController;
    private final AddCommand addCommand;
    private final DropCommand dropCommand;
    private final GoCommand goCommand;
    private final HelpCommand helpCommand;
    private final LookCommand lookCommand;
    private final QuitCommand quitCommand;
    private final ShowBagCommand showBagCommand;

    @Autowired
    private CommandFactory(GameController gameControllerParam, AddCommand addCommandParam, DropCommand dropCommandParam, GoCommand goCommandParam,
                          HelpCommand helpCommandParam, LookCommand lookCommandParam, QuitCommand quitCommandParam, ShowBagCommand showBagCommandParam) {
        gameController = gameControllerParam;
        addCommand = addCommandParam;
        dropCommand = dropCommandParam;
        goCommand = goCommandParam;
        helpCommand = helpCommandParam;
        lookCommand = lookCommandParam;
        quitCommand = quitCommandParam;
        showBagCommand = showBagCommandParam;
    }

    public void createLookCommand() {
        lookCommand.execute();
    }

    public void createShowBagCommand() {
        showBagCommand.execute();
    }

    public void createQuitCommand() {
        quitCommand.execute();
    }

    public void createHelpCommand() {
        helpCommand.execute();
    }

    public void createGoCommand(String secondPart) {
        String[] parts = secondPart.split(" +");
        if (parts.length == 2) {
            String direction = InputController.cleanInput(parts[1]);
            goCommand.setDirection(direction);
            goCommand.execute();
        } else {
            gameController.getViewFactory().getConsoleView().displayInvalidDirection();
        }
    }

    public void createAddCommand(String secondPart) {
        String[] parts = secondPart.split(" +");
        if (parts.length == 2) {
            String item = InputController.cleanInput(parts[1]);
            addCommand.setItemName(item);
            addCommand.execute();
        } else {
            gameController.getViewFactory().getConsoleView().displayInvalidNameItemToGet();
        }
    }

    public void createDropCommand(String secondPart) {
        String[] parts = secondPart.split(" +");
        if (parts.length == 2) {
            String item = InputController.cleanInput(parts[1]);
            dropCommand.setItemName(item);
            dropCommand.execute();
        } else {
            gameController.getViewFactory().getConsoleView().displayInvalidNameItemToDrop();
        }
    }

}