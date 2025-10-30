package taskList;

public class ReopenAction implements Command {
    @Override
    public void execute(String args) {
        // TODO validate args
        int taskIndex = Integer.parseInt(args) - 1;
        reopenTask(Main.taskList.get(taskIndex)); // Change to use args to find the correct task
    }

    private void reopenTask(Task task) {
        task.setStatus("PENDING"); // TODO enum status
        System.out.println("Atividade reaberta.");
    }
}
