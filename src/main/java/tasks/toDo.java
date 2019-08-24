/**
 * toDo.java
 * extension of task class
 * most basic type of item in duke
 */

package tasks;

public class toDo extends task{
    //protected String description;
    //protected boolean isDone;

    public toDo(String description) {
        super(description);

        String inputParsed[] = description.split(" ", 2);

        this.description = inputParsed[1];
        this.isDone = false;
        this.type = "toDo";
    }

    @Override
    public String getListInfo() {
        return ("[T] [" + this.getStatusIcon() + "] " + this.description);
    }
}
