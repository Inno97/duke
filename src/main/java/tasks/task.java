/**
 * task.java
 * base class for toDo, Deadline and Event class
 */

package tasks;

enum Type {
    TODO, EVENT, DEADLINE;
}

/**
 * the task class
 * base class for deadline, event and to do to inherit
 */
public class task {
    protected String description;
    protected boolean isDone;
    protected Type type;

    public task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Mark task as done
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Gets the status of the item (completed or not)
     * @return status the status of the item
     */
    public Boolean getStatus() { return this.isDone; }

    /**
     * Gets the status icon of the task
     * @return statusIcon the status icon to print
     */
    public String getStatusIcon() {
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }

    /**
     * Gets the description of the task
     * @return description the description of the item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the type of task
     * @return type the type of task
     */
    public String getType() { return this.type.toString(); }

    /**
     * Gets the information to list
     * @return listInfo the list info to print
     */
    public String getListInfo() {
        return ("[T] [" + this.getStatusIcon() + "] " + this.getDescription());
    }
}