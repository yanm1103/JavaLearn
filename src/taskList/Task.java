package taskList;

public class Task implements Comparable<Task> {
    private String name;
    private TaskStatus status;
    Integer priority;

    static Integer MAX_TASKS = 5;

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public void setPriority(int newPriority) {
        this.priority = newPriority;
    }

    public int getPriority() {
        return this.priority;
    }

    /**
     * Sets the maximum amount of tasks the user will be able to create.
     * 
     * @param newMaxTasks the new max number of possible tasks.
     */
    public static void setMaxTasks(Integer newMaxTasks) {
        MAX_TASKS = newMaxTasks;
    }

    /**
     * Prints the current task.
     * 
     * @param position Optional position of the task to print.
     */
    public void print(int position) {
        System.out.printf("%s) %s - %s | Prioridade: %s\n", positionToPrint(position), this.name,
                this.getStatus().getLabel(), this.priority);
    }

    private String positionToPrint(int position) {
        if (position == -1)
            return "";
        else
            return Integer.toString(position + 1);
    }

    public Task(String name, Integer priority) {
        this.name = name;
        this.status = TaskStatus.PENDING;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        return Integer.compare(this.priority, o.priority);
    }
}
