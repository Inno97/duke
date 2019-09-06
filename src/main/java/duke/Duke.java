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
 *
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

    public String getResponse(String input) throws dukeException {
        try {
            input newInput = new input(input);
            parser.parseInput(newInput);
            dukeMessage = parser.getDukeMessage();
            System.out.println("response success");
            System.out.println(dukeMessage);
        } catch (dukeException e) {
            ui.printException(e.getMessage());
        }

        return dukeMessage;
    }
}