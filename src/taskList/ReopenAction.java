package taskList;

public class ReopenAction implements Command {
    @Override
    public void execute(String args) {
        if (!args.isEmpty() && Commons.checkInt(args)) {
            int taskIndex = Commons.getTaskIndex(args);
            reopenTask(Main.taskList.get(taskIndex));
        } else {
            System.out.println("Por favor, digite a posição da atividade que deseja reabrir");
            System.out.println("(Use o comando list para verificar as posições)");
        }
    }

    private void reopenTask(Task task) {
        task.setStatus(TaskStatus.PENDING);
        System.out.println("Atividade reaberta.");
    }
}
