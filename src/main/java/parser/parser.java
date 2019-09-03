package parser;

import common.*;
import javafx.application.Platform;
import ui.*;
import storage.*;

import java.io.FileNotFoundException;

public class parser {
    private taskList taskList = new taskList();
    private boolean exitFlag = false;
    private ui ui = new ui();
    private searchEngine searchEngine = new searchEngine();

    private String dukeMessage = null; //return message that duke is supposed to send

    public parser() throws FileNotFoundException, dukeException {
    }

    //handle input
    public void parseInput(input newInput) throws dukeException {
        dukeMessage = "";
        switch(newInput.getCommand()) {
            case TODO:
                taskList.addToDo(newInput);
                dukeMessage = taskList.getDukeMessage();
                break;

            case EVENT:
                taskList.addEvent(newInput);
                dukeMessage = taskList.getDukeMessage();
                break;

            case DEADLINE:
                taskList.addDeadline(newInput);
                dukeMessage = taskList.getDukeMessage();
                break;

            case LIST:
                taskList.getTasks();
                dukeMessage = taskList.getDukeMessage();
                break;

            case DONE:
                taskList.markAsDone(newInput);
                dukeMessage = taskList.getDukeMessage();
                break;

            case DELETE:
                taskList.deleteTask(newInput);
                dukeMessage = taskList.getDukeMessage();
                break;

            case FIND:
                searchEngine.searchForTasks(taskList, newInput);
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

    public String getDukeMessage() { return dukeMessage; }

    private void exitProgram() {
        exitFlag = true;
        ui.printExitProgram();
        Platform.exit();
        System.exit(0);
    }

}
