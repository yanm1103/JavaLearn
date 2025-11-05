package taskList.command;

import taskList.Main;
import taskList.service.Commons;

public class RemoveAction implements Command {
    @Override
    public void execute(String args) {
        if (!args.isEmpty() && Commons.checkInt(args)) {
            int taskIndex = Commons.getTaskIndex(args);
            removeTaskByIndex(taskIndex);
        } else {
            System.out.println("Por favor, digite a posição da atividade que deseja remover.");
            System.out.println("(Use o comando list para verificar as posições)");
        }
    }

    private void removeTaskByIndex(int taskIndex) {
        try {
            Main.taskList.remove(taskIndex);
            System.out.println("Tarefa removida com sucesso.");
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Não foi possível remover a tarefa. Verifique o índice informado.");
        }
    }
}
