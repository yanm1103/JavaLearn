package taskList.command;

import inputUtils.InputUtils;
import taskList.Main;
import taskList.model.Task;
import taskList.service.Commons;

public class NameAction implements Command {
    @Override
    public void execute(String args) {
        try {
            int taskIndex = Commons.getTaskIndex(args);
            nameTask(Main.taskList.get(taskIndex));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Não foi possível renomear a tarefa. Verifique o índice informado.");
        }
    }

    public void nameTask(Task task) {
        String newName = InputUtils.getStringInput("Novo nome da atividade: ");
        task.setName(newName);
    }
}
