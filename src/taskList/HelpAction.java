package taskList;

import java.util.Map;

public class HelpAction implements Command {

    private final Map<String, String> commandMap = createCommandMap();

    @Override
    public void execute(String args) {
        displayHelp(args);
    }

    private void displayHelp(String command) {
        if (commandMap.containsKey(command)) {
            System.out.println(commandMap.get(command));
        } else {
            if (!command.isEmpty()) {
                System.out.println("Comando \"" + command + "\" não encontrado.");
                System.out.println("Exibindo a ajuda dos comandos disponíveis.");
            }
            for (String key : commandMap.keySet()) {
                System.out.println(commandMap.get(key));
            }
        }
    }

    private Map<String, String> createCommandMap() {
        return Map.of(
            "help", "help          - Exibe a descrição dos comandos. (você está aqui)",
            "list", "list          - Lista todas as atividades criadas e suas posições.",
            "add", "add <n>       - Adiciona n novas atividades. (padrão 1)",
            "remove", "remove <p>    - Remove a atividade na posição informada.",
            "complete", "complete <p>  - Complete a atividade na posição informada.",
            "reopen", "reopen <p>    - Reabre a atividade na posição informada.",
            "exit", "exit          - Sai da aplicação."
        );
    }
}
