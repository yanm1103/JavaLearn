package taskList.command;

import taskList.Main;
import taskList.model.Task;
import taskList.model.TaskStatus;
import taskList.service.Commons;

public class CompleteAction implements Command {
    @Override
    public void execute(String args) {
        if (!args.isEmpty() && Commons.checkInt(args)) {
            int taskIndex = Commons.getTaskIndex(args);
            completeTask(Main.taskList.get(taskIndex));
        } else {
            System.out.println("Por favor, digite a posição da atividade que deseja completar");
            System.out.println("(Use o comando list para verificar as posições)");
        }
    }

    private void completeTask(Task task) {
        task.setStatus(TaskStatus.DONE);
        System.out.println("Atividade concluída.");
    }
}
