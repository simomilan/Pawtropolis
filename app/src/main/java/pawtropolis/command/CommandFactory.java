package pawtropolis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pawtropolis.controller.GameController;
import pawtropolis.controller.InputController;
import pawtropolis.view.ConsoleView;


@Component
public class CommandFactory { //è un component

    private final GameController gameController;
    ConsoleView consoleView = new ConsoleView();

    @Autowired
    public CommandFactory(GameController gameController) {
        this.gameController = gameController;
    }
    public void createLookCommand() {
        LookCommand lookCommand = new LookCommand(gameController);
        lookCommand.execute();
    }

    public void createShowBagCommand() {
         ShowBagCommand showBagCommand = new ShowBagCommand(gameController);
         showBagCommand.execute();
    }

    public void createQuitCommand() {
         QuitCommand quitCommand = new QuitCommand(gameController);
         quitCommand.execute();
    }

    public void createHelpCommand() {
        HelpCommand helpCommand = new HelpCommand();
        helpCommand.execute();
    }

    public void createGoCommand(String secondPart) {
        try {
            String direction = InputController.cleanerInputMultipleWord(secondPart.split(" +")[1]);
            GoCommand goCommand = new GoCommand(gameController);
            goCommand.setDirection(direction);
            goCommand.execute();
        }catch (ArrayIndexOutOfBoundsException e){
            consoleView.displayInvalidDirection();
        }
    }

    public void createAddCommand(String secondPart) {
        try {
            String item = InputController.cleanerInputMultipleWord(secondPart.split(" +")[1]);
            AddCommand addCommand = new AddCommand(gameController);
            addCommand.setItemName(item);
            addCommand.execute();
        }catch (ArrayIndexOutOfBoundsException e){
            consoleView.displayInvalidNameItemToGet();
        }
    }

    public void createDropCommand(String secondPart) {
        try {
            String item = InputController.cleanerInputMultipleWord(secondPart.split(" +")[1]);
            DropCommand dropCommand = new DropCommand(gameController);
            dropCommand.setItemName(item);
            dropCommand.execute();
        }catch (ArrayIndexOutOfBoundsException e){
            consoleView.displayInvalidNameItemToDrop();
        }
    }
}

