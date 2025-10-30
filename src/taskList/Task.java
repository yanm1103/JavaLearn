package taskList;

public class Task implements Comparable<Task> {
    String name; // TODO getter setter
    String status; // TODO getter setter
    Integer priority; // TODO Unused for now

    static Integer MAX_TASKS = 5;

    /**
     * TODO Just a test, if someday this is configurable it needs a setter
     * 
     * @param newMaxTasks the new max number of possible tasks
     */
    public static void setMaxTasks(Integer newMaxTasks) {
        MAX_TASKS = newMaxTasks;
    }

    public Task(String name, Integer priority) {
        this.name = name;
        this.status = "PENDING"; // TODO Enum for statuses
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Task o) {
        // TODO Integer.compare might do the same
        if (this.priority > o.priority) {
            return 1;
        } else if (this.priority < o.priority) {
            return -1;
        } else
            return 0;
    }
}
