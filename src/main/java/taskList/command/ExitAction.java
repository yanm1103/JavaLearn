package taskList.command;

public class ExitAction implements Command {
    @Override
    public void execute(String args) {
        quit();
    }

    private void quit() {
        System.exit(0);
    }
}
