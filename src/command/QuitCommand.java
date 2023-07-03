package command;

import view.ConsoleView;

public class QuitCommand implements GameCommand {

    @Override
    public void execute(){
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayQuitCommand();
    }
}
