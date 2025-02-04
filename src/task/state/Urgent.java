package task.state;

import task.Task;

public class Urgent extends Pending {

    @Override
    public String getInfo(Task task) {
        return "[URGENT] " + super.getInfo(task);
    }

    @Override
    public void changePriority(Task task) {
        task.setState(new Pending());
    }

}
