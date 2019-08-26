/**
 * deadline.java
 * extension of task class
 * basically toDos with date
 */

package tasks;

import common.dukeException;
import tasks.*;

public class deadline extends task {
    //protected String description;
    //protected boolean isDone;
    protected date date;

    public deadline(String description) throws dukeException {
        super(description);

        //split description and date
        String inputParsed[] = description.split(" ", 2);
        String inputParams[] = inputParsed[1].split(" /by ", 2);

        if (inputParsed.length != 2 || inputParsed[1] == "" || !inputParsed[1].contains("/by")) {
            throw new dukeException("Invalid Deadline format.");
        }

        if (inputParams.length != 2 || inputParams[1] == "") {
            throw new dukeException("The date of a Deadline cannot be empty.");
        }

        this.description = inputParams[0];
        this.date = new date(inputParams[1]);
        this.isDone = false;
        this.type = "deadline";
    }

    @Override
    public String getListInfo() {
        return ("[D] [" + this.getStatusIcon() + "] " + this.description + " (by: " + this.getDateMonthDay() + ")");
    }

    public String getDate() {
        return this.date.getDate();
    }

    //get date with correct formatting
    public String getDateFormat() {
        return this.date.getDateFormat();
    }

    public String getDateMonthDay() {
        return this.date.getMonthDayFormat();
    }
}
