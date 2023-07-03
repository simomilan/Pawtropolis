package pawtropolis.command;

import org.springframework.stereotype.Component;
import pawtropolis.view.ConsoleView;
@Component
public class HelpCommand implements GameCommand {


    @Override
    public void execute() {
        ConsoleView consoleView = new ConsoleView();
        consoleView.displayHelpCommand();

    }
}