package taskList;

public class MaxTasksAction implements Command {

    @Override
    public void execute(String args) {
        if (!args.isEmpty() && Commons.checkInt(args)) {
            int newMax = Integer.parseInt(args);
            if (newMaxPositive(newMax))
                setMaxTasks(newMax);
            else
                System.out.println("Por favor, digite um número inteiro positivo.");
        } else {
            System.out.println("Por favor, digite o novo número máximo de atividades.");
        }
    }

    private boolean newMaxPositive(int newMax) {
        return newMax > 0;
    }

    private void setMaxTasks(int newMax) {
        System.out.printf("Número máximo de atividades alterado de %d para %d.\n", Task.MAX_TASKS, newMax);
        Task.setMaxTasks(newMax);
    }

}
