package taskList.command;

public class ExitAction implements Command {
    @Override
    public void execute(String args) {
        System.exit(0);
    }
}
