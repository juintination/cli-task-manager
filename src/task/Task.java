package task;

public class Task {

    private String title;
    private String description;
    private TaskState state;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.state = new Pending();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public boolean isDone() {
        return state instanceof Completed;
    }

    public String getInfo() {
        return state.getInfo(this);
    }

    public void changeDone() {
        state.changeDone(this);
    }

    public void changePriority() {
        state.changePriority(this);
    }

}
