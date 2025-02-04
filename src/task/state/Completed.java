package task.state;

import task.Task;

public class Completed extends TaskState {

    @Override
    public String getInfo(Task task) {
        return "\"" + task.getTitle() + " - " + task.getDescription() + "\" is completed.";
    }

    @Override
    public void changeDone(Task task) {
        task.setState(new Pending());
    }

    @Override
    public void changePriority(Task task) {
        // Do nothing
    }

}
