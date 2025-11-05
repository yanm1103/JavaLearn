package taskList;

import InputUtils.InputUtils;

public class PriorityAction implements Command {

    @Override
    public void execute(String args) {
        try {
            int taskIndex = Commons.getTaskIndex(args);
            setPriority(Main.taskList.get(taskIndex));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Não foi possível alterar a prioridade da tarefa. Verifique o índice informado.");
        }
        Commons.getArgsFromCommand(args);
    }

    private void setPriority(Task task) {
        int newPriority;
        while (true) {
            newPriority = InputUtils.getIntInput("Digite a nova prioridade para a atividade <de 1 a 5>: ");
            if (newPriority < 1 || newPriority > 5) {
                System.out.printf("Não é possível atribuir o valor %d. Tente novamente.\n", newPriority);
            } else break;
        }
        task.setPriority(newPriority);
    }
}
