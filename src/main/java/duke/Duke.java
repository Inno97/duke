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

import javaFx.MainWindow;

public class Duke {
    public static void main(String[] args) throws dukeException, FileNotFoundException {
        //setup
        ui ui = new ui();
        ui.printWelcome();

        Scanner sc = new Scanner(System.in);
        parser parser = new parser();

        while (!parser.getExitStatus()) {
            try {
                input newInput = new input(sc.nextLine());
                parser.parseInput(newInput);
            } catch (dukeException e) {
                ui.printException(e.getMessage());
            }
        }
    }

    public String getResponse(String input) {
        return input;
        //return "Duke heard: " + input;
    }
}