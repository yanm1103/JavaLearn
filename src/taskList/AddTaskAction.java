package taskList;

public class AddTaskAction implements Command {

    @Override
    public void execute(String args) {
        if (checkTaskListSize()) {
            if (Commons.validateArgs(args, true))
                createTasks(args);
        } else {
            System.out.println("Número máximo de atividades atingido.");
            System.out.println("Por favor remova algumas (use o comando remove)");
        }
    }

    private void createTasks(String quantityStr) {
        int total = howManyTasks(quantityStr);
        System.out.println("Registrando uma nova atividade nas posições: ");
        for (int i = 0; i < total; i++) {
            Task newTask = createTask();
            Main.taskList.add(newTask);
            ListAction.printTask(newTask, Main.taskList.size() - 1); // TODO jogar isso no Commons ou na própria task
        }
    }

    private int howManyTasks(String quantityStr) {
        int tasksToCreate = 1;
        if (!quantityStr.isEmpty()) // More than one task
            tasksToCreate = Integer.valueOf(quantityStr);
        return tasksToCreate;
    }

    private Task createTask() {
        // TODO receive name and priority from user input
        String name = "Nova atividade";
        Integer priority = 1;
        return new Task(name, priority);
    }

    private boolean checkTaskListSize() {
        return Main.taskList.size() < Task.MAX_TASKS;
    }
}
