package tasks;

public class task {
    protected String description;
    protected boolean isDone;

    public task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }

    public String getDescription() {
        return description;
    }
}
