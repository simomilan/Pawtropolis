package command;

import controller.GameController;
import view.ConsoleView;

public class QuitCommand implements GameCommand {

    //TODO: costruttore che passa GameController

    @Override
    public void execute(){
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayQuitCommand();
    }

    public static void executeQuitCommand(GameController gameController) {
        QuitCommand quitCommand = new QuitCommand();
        quitCommand.execute();
    }
}
