package taskList;

public class CompleteAction implements Command {
    @Override
    public void execute(String args) {
        // TODO validate args
        int taskIndex = Integer.parseInt(args) - 1;
        completeTask(Main.taskList.get(taskIndex));
    }

    private void completeTask(Task task) {
        task.setStatus("DONE"); // TODO enum status
        System.out.println("Atividade concluída.");
    }
}
