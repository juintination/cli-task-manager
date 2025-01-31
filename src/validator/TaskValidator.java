package validator;

import task.*;

public class TaskValidator {

    private static final String INPUT_ERROR_MESSAGE = "Error has occurred. Please enter it again.";
    private static final String NAME_ERROR_MESSAGE = "Name cannot be empty. Please enter it again.";
    private static final String TASK_TITLE_ERROR_MESSAGE = "Title cannot be empty. Please enter it again.";
    private static final String TASK_DESCRIPTION_ERROR_MESSAGE = "Description cannot be empty. Please enter it again.";
    private static final String TASK_COMPLETED_ERROR_MESSAGE = "Completed task's priority cannot be modified.";

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    public static void validateTaskTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException(TASK_TITLE_ERROR_MESSAGE);
        }
    }

    public static void validateTaskDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException(TASK_DESCRIPTION_ERROR_MESSAGE);
        }
    }

    public static void validateChoice(String choice) {
        if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("0")) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateTaskIndex(String index, int taskSize) {
        if (index.isEmpty() || !index.matches("[0-9]+") || Integer.parseInt(index) < 0 || Integer.parseInt(index) > taskSize) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateIsPendingOrUrgent(Task task) {
        if (task.getState() instanceof Completed) {
            throw new IllegalArgumentException(TASK_COMPLETED_ERROR_MESSAGE);
        }
    }
}
