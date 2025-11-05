package taskList;

public class ListAction implements Command {
    @Override
    public void execute(String args) {
        listTasks();
    }

    private void listTasks() {
        if (Main.taskList.isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada. (use o comando add para criar uma)");
            return;
        }
        for (int taskIndex = 0; taskIndex < Main.taskList.size(); taskIndex++) {
            Task currentTask = Main.taskList.get(taskIndex);
            currentTask.print(taskIndex);
        }
    }
}
