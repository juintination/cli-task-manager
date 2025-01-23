import task.*;

import java.io.*;
import java.util.*;

public class TaskManager {

    private static TaskManager taskManager;

    private final String INPUT_ERROR_MESSAGE = "Error has occurred. Please enter it again.";
    private final String NAME_ERROR_MESSAGE = "Name cannot be empty. Please enter it again.";
    private final String TASK_TITLE_ERROR_MESSAGE = "Title cannot be empty. Please enter it again.";
    private final String TASK_DESCRIPTION_ERROR_MESSAGE = "Description cannot be empty. Please enter it again.";

    private String name;
    private BufferedReader br;
    private List<BasicTask> tasks;

    private TaskManager() {
        name = "";
        br = new BufferedReader(new InputStreamReader(System.in));
        tasks = new ArrayList<>();
    }

    public static TaskManager getInstance() {
        if (taskManager == null) {
            taskManager = new TaskManager();
        }
        return taskManager;
    }

    public void offerTask(BasicTask task) {
        tasks.add(task);
    }

    public void start() {
        inputName();
        while (true) {
            printWelcomeMessage();
            byte choicedNumber = inputChoice();
            if (!taskLoop(choicedNumber)) {
                break;
            }
        }
    }

    private void inputName() {
        while (true) {
            System.out.print("Please enter your name: ");
            try {
                String name = br.readLine();
                validateName(name);
                this.name = name;
                break;
            } catch (IOException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    private void printWelcomeMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHi, ").append(name).append("! ")
                .append("Welcome to CLI Task Manager. What would you like to do?\n")
                .append("1. View tasks\n")
                .append("2. Add a task\n")
                .append("3. Modify tasks\n")
                .append("4. Remove a task\n")
                .append("0. Exit");
        System.out.println(sb);
    }

    private byte inputChoice() {
        while (true) {
            try {
                String choice = br.readLine();
                validateChoice(choice);
                return Byte.parseByte(choice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            }
        }
    }

    private void validateChoice(String choice) {
        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") &&!choice.equals("0")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private boolean taskLoop(byte choicedNumber) {
        boolean isContinue = true;
        switch (choicedNumber) {
            case 1:
                // viewTasks();
                break;
            case 2:
                addTask();
                break;
            case 3:
                // modifyTasks();
                break;
            case 4:
                // removeTask();
                break;
            case 0:
                System.out.println("Goodbye, " + name + "!");
                isContinue = false;
                break;
        }
        return isContinue;
    }

    private void addTask() {
        String title = inputTaskTitle();
        String description = inputTaskDescription();
        offerTask(new PendingTask(title, description));
    }

    private String inputTaskTitle() {
        while (true) {
            System.out.print("Enter the title of the task: ");
            try {
                String title = br.readLine();
                validateTaskTitle(title);
                return title;
            } catch (IOException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateTaskTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException(TASK_TITLE_ERROR_MESSAGE);
        }
    }

    private String inputTaskDescription() {
        while (true) {
            System.out.print("Enter the description of the task: ");
            try {
                String description = br.readLine();
                validateTaskDescription(description);
                return description;
            } catch (IOException e) {
                System.out.println(INPUT_ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateTaskDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException(TASK_DESCRIPTION_ERROR_MESSAGE);
        }
    }

}
