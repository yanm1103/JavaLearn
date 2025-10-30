package taskList;

import java.util.*;

public class ListAction implements Command {
    @Override
    public void execute(String args) {
        listTasks();
    }

    private void listTasks() {
        if (Main.taskList.isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada. (use o comando add para criar uma)");
            return;
        }
        for (int taskIndex = 0; taskIndex < Main.taskList.size(); taskIndex++) {
            // TODO ordenar por prioridade
            printTask(Main.taskList.get(taskIndex), taskIndex);
        }
    }

    public static void printTask(Task task, int position) {
        Map<String, String> statusMap = new HashMap<>(); // TODO enum status
        statusMap.put("PENDING", "Pendente");
        statusMap.put("DONE", "Concluída");
        String shouldPrintPosition = (position == -1 ? "" : Integer.toString(position + 1)); // TODO confuso
        System.out.println(shouldPrintPosition + ": " + task.name + " - " + statusMap.get(task.status)
                + " - Prioridade: " + task.priority);
    }
}
