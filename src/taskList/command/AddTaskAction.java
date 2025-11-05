package taskList.command;

import taskList.Main;
import taskList.model.Task;
import taskList.service.Commons;

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
        for (int i = 0; i < total; i++) {
            if (isTaskLimitReached()) {
                System.out.printf("Número máximo de atividades atingido (%d). Remova alguma antes de adicionar novas.\n", Task.getMaxTasks());
                return;
            }
            System.out.println("Registrando uma nova atividade.");
            Task newTask = createTask();
            Main.taskList.add(newTask);
            nameNewTask();
            System.out.println("Nova atividade gerada.");
            newTask.print(Main.taskList.size() - 1);
            System.out.println("-------------------------------");
        }
    }

    private void nameNewTask() {
        NameAction nameAction = new NameAction();
        nameAction.execute(Integer.toString(Main.taskList.size()));
    }

    private int howManyTasks(String quantityStr) {
        int tasksToCreate = 1;
        if (!quantityStr.isEmpty()) // More than one task
            tasksToCreate = Integer.parseInt(quantityStr);
        return tasksToCreate;
    }

    private boolean isTaskLimitReached() {
        return Main.taskList.size() >= Task.getMaxTasks();
    }

    private Task createTask() {
        String name = "Nova atividade...";
        Integer priority = 1;
        return new Task(name, priority);
    }

    private boolean checkTaskListSize() {
        return Main.taskList.size() < Task.getMaxTasks();
    }
}
