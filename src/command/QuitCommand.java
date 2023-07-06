package command;

import view.ConsoleView;

public class QuitCommand implements GameCommand {

    //TODO: costruttore che passa GameController

    @Override
    public void execute(){
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayQuitCommand();
    }
}
