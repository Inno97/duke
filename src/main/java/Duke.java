/**
 * duke.java
 * Main app file for duke
 */

import java.io.*;
import java.util.*;

import common.dukeException;
import tasks.*;
import parser.*;
import ui.*;

public class Duke {
    public static void main(String[] args) throws dukeException {
        //setup
        Scanner sc = new Scanner(System.in);
        textGUI ui = new textGUI();
        parser parser = new parser();

        ui.printWelcome();

        //duke level 1-3: mark as done
        //Add the ability to mark tasks as done.
        while (!parser.getExitStatus()) {
            try {
                input newInput = new input(sc.nextLine());
                parser.parseInput(newInput);
            } catch (dukeException e) {
                ui.printException(e.getMessage());
            }
        }
    }
}
