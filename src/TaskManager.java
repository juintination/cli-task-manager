import java.io.*;

public class TaskManager {

    private static TaskManager taskManager;

    private final String INPUT_ERROR_MESSAGE = "Error has occurred. Please enter it again.";
    private final String NAME_ERROR_MESSAGE = "Name cannot be empty. Please enter it again.";

    private String name;
    private BufferedReader br;

    private TaskManager() {
        name = "";
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static TaskManager getInstance() {
        if (taskManager == null) {
            taskManager = new TaskManager();
        }
        return taskManager;
    }

    public void start() {
        inputName();
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

}
