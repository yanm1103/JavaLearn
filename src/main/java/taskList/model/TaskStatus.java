package taskList.model;

public enum TaskStatus {
    PENDING("Pendente"), DONE("Concluída");

    private final String label;

    TaskStatus(String status) {
        this.label = status;
    }

    public String getLabel() {
        return label;
    }

    public static TaskStatus fromString(String status) {
        try {
            return TaskStatus.valueOf(status.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
