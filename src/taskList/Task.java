package taskList;

public class Task implements Comparable<Task> {
    String name;
    String status;
    Integer priority;

    static Integer MAX_TASKS = 5;

    /**
     * Just a test, if someday this is configurable it needs a setter
     * 
     * @param newMaxTasks the new max number of possible tasks
     */
    public static void setMaxTasks(Integer newMaxTasks) {
        MAX_TASKS = newMaxTasks;
    }

    public Task(String name, Integer priority) {
        this.name = name;
        this.status = "PENDING";
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Task o) {
        try {
            if (this.priority > o.priority) {
                return 1;
            } else if (this.priority < o.priority) {
                return -1;
            } else
                return 0;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
        }
    }
}
