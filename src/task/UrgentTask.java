package task;

public class UrgentTask extends PendingTask {

    public UrgentTask(String title, String description) {
        super(title, description);
    }

    @Override
    public String getInfo() {
        return "[URGENT] " + super.getInfo();
    }

}
