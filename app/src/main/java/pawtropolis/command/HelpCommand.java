package pawtropolis.command;

import pawtropolis.view.ConsoleView;

public class HelpCommand implements GameCommand {


    @Override
    public void execute() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayHelpCommand();

    }
}