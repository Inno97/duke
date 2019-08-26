/**
 * event.java
 * extension of task class
 * basically toDos but with location
 */

package tasks;

import common.*;

public class event extends task{
    //protected String description;
    //protected boolean isDone;
    protected String date;

    public event(String description) throws dukeException {
        super(description);

        //split description and date
        String inputParsed[] = description.split(" ", 2);
        String inputParams[] = inputParsed[1].split(" /at ", 2);

        if (inputParsed.length != 2 || inputParsed[1] == "" || !inputParsed[1].contains("/at")) {
            throw new dukeException("Invalid Event format.");
        }

        if (inputParams.length != 2 || inputParams[1] == "") {
            throw new dukeException("The date of an Event cannot be empty.");
        }

        this.description = inputParams[0];
        this.date = inputParams[1];
        this.isDone = false;
        this.type = "event";
    }

    @Override
    public String getListInfo() {
        return ("[E] [" + this.getStatusIcon() + "] " + this.description + " (at: " + this.date + ")");
    }

    public String getDate() {
        return this.date;
    }
}
