package taskList;

public class RemoveAction implements Command {
    @Override
    public void execute(String args) {
        if (!args.isEmpty() && Commons.checkInt(args)) {
            int taskIndex = Integer.parseInt(args) - 1;
            removeTaskByIndex(taskIndex);
        } else {
            System.out.println("Por favor, digite o ID da atividade que deseja remover");
            System.out.println("(Use o comando list para verificar os IDs)");
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
