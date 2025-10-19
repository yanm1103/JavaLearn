package taskList;

import java.util.*;
import InputUtils.InputUtils;

public class Main {

    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        taskExecutionLoop();
    }

    public static void taskExecutionLoop() {
        System.out.println("Bem vindo ao Google Keep de 1 real.");
        System.out.println("Para começar, vamos cadastrar suas atividades...");
        while (true) {
            String command = InputUtils.getStringInput("Digite o comando desejado (help/list/select/add/exit): ");
            switch (command) {
            case "help":
                displayHelp();
                break;
            case "list":
                listTasks();
                break;
            case "select":
                askToSelectTask();
                break;
            case "add":
                addNewTask();
                break;
            case "edit":
                break;
            default:
                System.out.println("Comando não reconhecido.");
            }
        }
    }

    public static void addNewTask() {
        if (taskList.size() < Task.MAX_TASKS)
            taskList.add(registerNewTask());
        else
            System.out.println("Número máximo de atividades atingido. Por favor remova algumas (use o comando remove)");
    }

    public static void listTasks() {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("PENDING", "Pendente");
        statusMap.put("DONE", "Concluída");
        for (int i = 0; i < taskList.size(); i++) {
            Task currentTask = taskList.get(i);
            System.out.println((i + 1) + ": " + currentTask.name + " - " + statusMap.get(currentTask.status)
                    + " - Prioridade: " + currentTask.priority);
        }
    }

    public static void askToSelectTask() {
        while (true) {
            int taskToChange = InputUtils.getIntInput("Qual atividade deseja modificar? ") - 1;
            try {
                Task selectedTask = taskList.get(taskToChange);
                taskCRUD(selectedTask);
                break;
            } catch (Exception e) {
                System.out.println(
                        "Por favor insira um número de atividade válido conforme a lista (use o comando list).");
            }
        }
    }

    public static void taskCRUD(Task task) {
        while (true) {
            String action = InputUtils.getStringInput("O que deseja fazer? (complete/rename/priority/remove/cancel)");
            switch (action) {
            case "complete":
                task.setStatus("DONE");
                System.out.println("Atividade marcada como concluída.");
                return;
            case "reopen":
                task.setStatus("PENDING");
                System.out.println("Atividade reaberta como pendente.");
                return;
            case "rename":
                String newName = registerNewTaskName();
                task.name = newName;
                System.out.println("Atividade renomeada.");
                return;
            case "priority":
                Integer newPriority = registerNewTaskPriority();
                task.priority = newPriority;
                System.out.println("Prioridade da atividade alterada.");
                return;
            case "remove":
                taskList.remove(task);
                System.out.println("Atividade removida.");
                return;
            case "cancel":
                break;
            default:
                System.out.println("Ação não reconhecida.");
            }
        }
    }

    public static void displayHelp() {
        System.out.println("(help/list/add/exit)");
        System.out.println("help   - Exibe a descrição dos comandos. (você está aqui)");
        System.out.println("list   - Lista todas as atividades criadas");
        System.out.println("select - onde é possível editar nome, prioridade, status ou removê-las");
        System.out.println("add    - Adiciona uma nova atividade");
        System.out.println("exit   - sai da aplicação.");
    }

    public static List<Task> recordTasks() {
        taskList = new ArrayList<>();
        Integer howManyTasks = askForHowManyTasks();
        for (int i = 0; i < howManyTasks; i++) {
            taskList.add(registerNewTask());
        }
        
        return taskList;
    }

    public static Task registerNewTask() {
        System.out.println("Registrando nova atividade.");
        String name = registerNewTaskName();
        Integer priority = registerNewTaskPriority();
        return new Task(name, priority);
    }

    public static Integer registerNewTaskPriority() {
        int priority = 0;
        do {
            priority = InputUtils.getIntInput("Digite a prioridade dessa atividade de 1 a 5: ");
        } while (priority <= 0 || priority > 5);
        return Integer.valueOf(priority);
    }

    public static String registerNewTaskName() {
        String name = "";
        do {
            name = InputUtils.getStringInput("Digite o nome da atividade: ");
        } while (name.isEmpty());
        return name.trim();
    }

    public static Integer askForHowManyTasks() {
        Integer inTasksToCreate = 0;
        do {
            inTasksToCreate = InputUtils.getIntInput("Quantas atividades deseja criar? (de 1 a 5): ");
            if (inTasksToCreate <= 0 || inTasksToCreate > Task.MAX_TASKS)
                System.out.println("Por favor insira um número de 1 a " + Task.MAX_TASKS + "!");
            else
                break;
        } while (inTasksToCreate <= 0 || inTasksToCreate > 5);
        return inTasksToCreate;
    }
}
