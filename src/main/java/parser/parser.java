package parser;

import common.*;
import ui.*;

import java.io.FileNotFoundException;

public class parser {
    private taskList taskList = new taskList();
    private boolean exitFlag = false;
    private ui ui = new ui();

    public parser() throws FileNotFoundException, dukeException {

    }

    //handle input
    public void parseInput(input newInput) throws dukeException {
        switch(newInput.getCommand()) {
            case "todo":
                taskList.addToDo(newInput);
                break;

            case "event":
                taskList.addEvent(newInput);
                break;

            case "deadline":
                taskList.addDeadline(newInput);
                break;

            case "list":
                taskList.printTasks();
                break;

            case "done":
                taskList.markAsDone(newInput);
                break;

            case "delete":
                taskList.deleteTask(newInput);
                break;

            case "bye":
                exitProgram();
                break;

            default:
                throw new dukeException("I'm sorry, but I don't know what that means.");
        }
    }

    public boolean getExitStatus() {
        return this.exitFlag;
    }

    private void exitProgram() {
        exitFlag = true;
        ui.printExitProgram();
    }
}
