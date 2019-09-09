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

    /**
     * Gets the information to list
     * @return listInfo the list info to print
     */
    @Override
    public String getListInfo() {
        return ("[E] [" + this.getStatusIcon() + "] " + this.description + " (at: " + this.getMonthDayTimeFormat() + ")");
    }

    /**
     * Gets the date of the event
     * @return date the date of the event
     */
    public String getDate() { return this.date.getDate(); }

    /**
     * Gets date with date format
     * @return date the date of the dateline with date format
     */
    public String getDateFormat() {
        return this.date.getDateFormat();
    }

    /**
     * Gets date with the date month day format
     * @return date the date in the date month day format
     */
    public String getDateMonthDay() {
        return this.date.getMonthDayFormat();
    }

    /**
     * Gets date with the month day time format
     * @return date the date in month day time format
     */
    public String getMonthDayTimeFormat() {return this.date.getMonthDayTimeFormat(); }
}
