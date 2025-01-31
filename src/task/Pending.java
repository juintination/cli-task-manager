package task;

public class Pending extends TaskState {

    @Override
    public String getInfo(Task task) {
        return "\"" + task.getTitle() + " - " + task.getDescription() + "\" is pending.";
    }

    @Override
    public void changeDone(Task task) {
        task.setState(new Completed());
    }

    @Override
    public void changePriority(Task task) {
        task.setState(new Urgent());
    }

}
