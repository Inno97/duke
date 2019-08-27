/**
 * task.java
 * base class for toDo, Deadline and Event class
 */

package tasks;

enum Type {
    TODO, EVENT, DEADLINE;
}

public class task {
    protected String description;
    protected boolean isDone;
    protected Type type;

    public task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public Boolean getStatus() { return this.isDone; }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return this.type.toString();
    }

    public String getListInfo() {
        return ("[T] [" + this.getStatusIcon() + "] " + this.getDescription());
    }
}