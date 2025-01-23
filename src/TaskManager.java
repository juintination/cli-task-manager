public class TaskManager {

    private static TaskManager taskManager;

    private TaskManager() {
    }

    public static TaskManager getInstance() {
        if (taskManager == null) {
            taskManager = new TaskManager();
        }
        return taskManager;
    }

    public void start() {
        System.out.println("Task manager started!");
    }

}
