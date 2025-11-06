package taskList;

import taskList.command.CommandEnum;
import taskList.model.Task;
import taskList.service.Commons;
import taskList.service.JSONUtils;

import java.util.*;

import inputUtils.InputUtils;

public class Main {

    public static List<Task> taskList;

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        taskList = JSONUtils.loadTasks();
        while (true) {
            String input = InputUtils.getStringInput("Digite o comando: ");
            CommandEnum commandEnum = CommandEnum.fromString(Commons.getCommandFromInput(input.toLowerCase()));
            if (commandEnum != null) {
                commandEnum.execute(Commons.getArgsFromCommand(input));
                JSONUtils.saveTasks(taskList);
            }
            else
                System.out.println("Comando inválido. Digite 'help' para ver uma lista de comandos disponíveis.");
        }
    }
}
