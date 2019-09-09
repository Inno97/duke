package parser;

import common.*;
import javafx.application.Platform;
import ui.*;
import storage.*;

import java.io.FileNotFoundException;

/**
 * the parser class
 * Handles all input parsing for duke, and executes appropriate actions
 */
public class parser {
    private taskList taskList = new taskList();
    private boolean exitFlag = false;
    private ui ui = new ui();
    private searchEngine searchEngine = new searchEngine();

    private String dukeMessage = null; //return message that duke is supposed to send

    public parser() throws FileNotFoundException, dukeException {
    }

    /**
     * Parse the given input for Duke
     * @param newInput the new input
     * @throws dukeException the exception that is thrown by Duke
     */
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
                dukeMessage = searchEngine.getSearchMessage();
                break;

            case BYE:
                exitProgram();
                break;

            default:
                throw new dukeException("I'm sorry, but I don't know what that means.");
        }
    }

    /**
     * Gets the exit status of Duke
     * @return exitFlag the boolean corresponding to whether or not Duke has exited or not
     */
    public boolean getExitStatus() {
        return this.exitFlag;
    }

    /**
     * Gets the message that Duke wants to send
     * @return dukeMessage the message that Duke has
     */
    public String getDukeMessage() { return dukeMessage; }

    public int getNumInTaskList() {
        return taskList.getSize();
    }

    /**
     * Shuts down Duke
     */
    private void exitProgram() {
        exitFlag = true;
        ui.printExitProgram();
        Platform.exit();
        System.exit(0);
    }

}
