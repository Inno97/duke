package tasks;

import tasks.*;

public class deadline extends task {
    //protected String description;
    //protected boolean isDone;
    protected String date;

    public deadline(String description) {
        super(description);

        //split description and date
        String inputParsed[] = description.split(" ", 2);
        String inputParams[] = inputParsed[1].split(" /by ", 2);

        this.description = inputParams[0];
        this.date = inputParams[1];
        this.isDone = false;
        this.type = "event";
    }

    @Override
    public String getListInfo() {
        return ("[D] [" + this.getStatusIcon() + "] " + this.description + " (by: " + this.date + ")");
    }


}
