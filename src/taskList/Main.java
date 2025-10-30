package taskList;

import java.util.*;

import InputUtils.InputUtils;

public class Main {

    public static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            String input = InputUtils.getStringInput("Digite o comando: ");
            CommandEnum commandEnum = CommandEnum.fromString(Commons.getCommandFromInput(input.toLowerCase()));
            if (commandEnum != null) {
                commandEnum.execute(Commons.getArgsFromCommand(input));
            } else {
                System.out.println("Comando inválido. Digite 'help' para ver uma lista de comandos disponíveis.");
            }
        }
    }
}
