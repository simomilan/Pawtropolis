package pawtropolis.src.command;

import pawtropolis.src.view.ConsoleView;

public class HelpCommand implements GameCommand {


    @Override
    public void execute() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayHelpCommand();

    }

    public static void executeHelpCommand() {
        HelpCommand helpCommand = new HelpCommand();
        helpCommand.execute();
    }

}