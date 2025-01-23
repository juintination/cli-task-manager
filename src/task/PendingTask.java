package task;

public class PendingTask extends BasicTask {

    public PendingTask(String title, String description) {
        super(title, description, false);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " is pending.";
    }

}
