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
            case TODO:
                taskList.addToDo(newInput);
                break;

            case EVENT:
                taskList.addEvent(newInput);
                break;

            case DEADLINE:
                taskList.addDeadline(newInput);
                break;

            case LIST:
                taskList.printTasks();
                break;

            case DONE:
                taskList.markAsDone(newInput);
                break;

            case BYE:
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
