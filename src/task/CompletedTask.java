package task;

public class CompletedTask extends BasicTask {

    public CompletedTask(String title, String description) {
        super(title, description, true);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " is completed.";
    }

}
