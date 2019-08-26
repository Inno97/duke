package tasks;

public class event extends task{
    //protected String description;
    //protected boolean isDone;
    protected String date;

    public event(String description) {
        super(description);

        //split description and date
        String inputParsed[] = description.split(" ", 2);
        String inputParams[] = inputParsed[1].split(" /at ", 2);

        this.description = inputParams[0];
        this.date = inputParams[1];
        this.isDone = false;
        this.type = "event";
    }

    @Override
    public String getListInfo() {
        return ("[E] [" + this.getStatusIcon() + "] " + this.description + " (at: " + this.date + ")");
    }

}
