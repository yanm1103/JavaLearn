package taskList;

import InputUtils.InputUtils;

public class NameAction implements Command {
    @Override
    public void execute(String args) {
        try {
            int taskIndex = Integer.parseInt(args) - 1;
            nameTask(Main.taskList.get(taskIndex));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Não foi possível renomear a tarefa. Verifique o índice informado.");
        }
    }

    public void nameTask(Task task) {
        String newName = InputUtils.getStringInput("Renomeando a atividade: ");
        task.name = newName;
    }
}
