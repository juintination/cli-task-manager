import task.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {

    private static final String TASKS_DIRECTORY = "tasks";

    static {
        ensureFileDirectoryExists();
    }

    private static void ensureFileDirectoryExists() {
        File directory = new File(TASKS_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public static boolean nameFileExists(String name) {
        try (BufferedReader ignored = new BufferedReader(new FileReader(TASKS_DIRECTORY + "/" + name + ".txt"))) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void loadTasks(String name, List<Task> tasks) {
        try (BufferedReader reader = new BufferedReader(new FileReader(TASKS_DIRECTORY + "/" + name + ".txt"))) {
            if (tasks.isEmpty()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] taskData = line.split(",");
                    if (taskData.length == 3) {
                        Task task = new Task(taskData[0], taskData[1]);
                        if (taskData[2].equals("Completed")) {
                            task.changeDone();
                        } else if (taskData[2].equals("Urgent")) {
                            task.changePriority();
                        }
                        tasks.add(task);
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load tasks: " + e.getMessage());
        }
    }

    public static void createTasksFile(String name) {
        try (FileWriter ignored = new FileWriter(TASKS_DIRECTORY + "/" + name + ".txt")) {
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to create " + name + ".txt: " + e.getMessage());
        }
    }

    public static void appendTaskToFile(String name, Task task) {
        try (FileWriter writer = new FileWriter(TASKS_DIRECTORY + "/" + name + ".txt", true)) {
            writer.write(task.getTitle() + "," + task.getDescription() + "," + task.getState().getClass().getSimpleName() + "\n");
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to append task to tasks.txt: " + e.getMessage());
        }
    }

    public static void updateTasksFile(String name, List<Task> tasks) {
        try (FileWriter writer = new FileWriter(TASKS_DIRECTORY + "/" + name + ".txt")) {
            writer.write(name + "\n");
            for (Task task : tasks) {
                writer.write(task.getTitle() + "," + task.getDescription() + "," + task.getState().getClass().getSimpleName() + "\n");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to update tasks.txt: " + e.getMessage());
        }
    }

}
