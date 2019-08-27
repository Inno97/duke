/**
 * event.java
 * extension of task class
 * basically toDos but with location
 */

package tasks;

import common.*;
import tasks.*;

public class event extends task{
    //inherited variables
    //protected String description;
    //protected boolean  isDone;

    protected date date;

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
        this.date = new date(inputParams[1]);
        this.isDone = false;
        this.type = Type.EVENT;
    }

    @Override
    public String getListInfo() {
        return ("[E] [" + this.getStatusIcon() + "] " + this.description + " (at: " + this.getMonthDayTimeFormat() + ")");
    }

    public String getDate() { return this.date.getDate(); }

    public String getDateFormat() {
        return this.date.getDateFormat();
    }

    public String getDateMonthDay() {
        return this.date.getMonthDayFormat();
    }

    public String getMonthDayTimeFormat() {return this.date.getMonthDayTimeFormat(); }
}
