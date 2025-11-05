package taskList;

public enum CommandEnum {
    HELP(new HelpAction()), LIST(new ListAction()), ADD(new AddTaskAction()), EXIT(new ExitAction()),
    NAME(new NameAction()), PRIORITY(new PriorityAction()), REMOVE(new RemoveAction()), COMPLETE(new CompleteAction()),
    REOPEN(new ReopenAction()), MAX(new MaxTasksAction());

    private final Command action;

    CommandEnum(Command action) {
        this.action = action;
    }

    public void execute(String args) {
        action.execute(args);
    }

    public static CommandEnum fromString(String command) {
        try {
            return CommandEnum.valueOf(command.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
