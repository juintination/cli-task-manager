package task;

public class BasicTask {

    String title;
    String description;
    boolean isDone;

    public BasicTask(String title, String description, boolean isDone) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
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

    public boolean isDone() {
        return isDone;
    }

    public String getInfo() {
        return "\"" + title + " - " + description + "\"";
    }

}
