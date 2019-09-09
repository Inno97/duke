/**
 * duke.java
 * Main app file for duke
 */

package duke;

import java.io.*;
import java.util.*;

import common.dukeException;
import tasks.*;
import parser.*;
import ui.*;

/**
 * The Duke class
 * handles all inputs and saves output in dukeMessage
 * for use in GUI
 */
public class Duke {
    private ui ui = new ui();
    private Scanner sc = new Scanner(System.in);
    private parser parser = new parser();

    private String dukeMessage = null;

    public Duke() throws FileNotFoundException, dukeException {
        //ui.printWelcome();
    }

    public String getWelcome() {
        return ui.getWelcome();
    }

    /**
     * Tries to get a response from Duke
     * @param input The user input
     * @return dukeMessage The message that Duke will show to the user
     * @throws dukeException Exception that Duke throws
     */
    public String getResponse(String input) throws dukeException {
        parseRequest(input);
        return fetchMessage();
    }

    /**
     * Send a request to Duke, who interprets and saves response
     * in dukeMessage
     * @param input The user input
     * @throws dukeException Exception that Duke throws
     */
    public void parseRequest(String input) throws dukeException {
        input newInput = new input(input);
        parser.parseInput(newInput);
        dukeMessage = parser.getDukeMessage();
        System.out.println("response success");
    }

    /**
     * Fetches the message that Duke has at the moment
     * @return dukeMessage The message that Duke will send
     */
    public String fetchMessage() {
        return dukeMessage;
    }

    /**
     * Gets the number of tasks in the task list
     * @return the number of tasks in the task list
     */
    public int getNumTasks() {
        return parser.getNumInTaskList();
    }
}