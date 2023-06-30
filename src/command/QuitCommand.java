package command;

public class QuitCommand implements GameCommand {

    @Override
    public void execute(){
        System.out.println("\n See you next time!");
    }
}
