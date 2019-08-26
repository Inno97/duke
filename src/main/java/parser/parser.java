/**
 * parser.java
 * parser object to handle user input
 * call constructor in Duke.java
 */

package parser;

import tasks.*;
import java.util.*;
import common.*;
import ui.*;

public class parser {
    private String input = "";
    private ArrayList<task> taskList = new ArrayList<task>(0);
    private int numTasks = 0;
    private boolean exitFlag = false;

    private textGUI ui = new textGUI();

    public parser() {
    }

    //handle input
    public void parseInput(input newInput) throws dukeException {
        switch(newInput.getCommand()) {
            case "todo":
                addToDo(newInput);
                break;

            case "event":
                addEvent(newInput);
                break;

            case "deadline":
                addDeadline(newInput);
                break;

            case "list":
                printTasks();
                break;

            case "done":
                markAsDone(newInput);
                break;

            case "delete":
                deleteTask(newInput);
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

    private void printTasks() {
        ui.printTasks(taskList);
    }

    private void addToDo(input newInput) {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new toDo(newInput.getInput()));
            numTasks++;
            ui.printAddToDo(taskList.get(numTasks - 1), numTasks);
        }
    }

    private void addEvent(input newInput) throws dukeException {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new event(newInput.getInput()));
            numTasks++;
            ui.printAddEvent(taskList.get(numTasks - 1), numTasks);
        }
    }

    private void addDeadline(input newInput) throws dukeException{
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new deadline(newInput.getInput()));
            numTasks++;
            ui.printAddDeadline(taskList.get(numTasks - 1), numTasks);
        }
    }

    private void markAsDone(input newInput) throws dukeException{
        if (newInput.getParam().equals("")) {
            throw new dukeException("Please enter a number.");
        }
        if (!newInput.getParam().matches("-?(0|[1-9]\\d*)")) {
            throw new dukeException("Please enter a number");
        }
        if ((Integer.parseInt(newInput.getParam())) > numTasks) {
            throw new dukeException("Sorry, but that task does not exist.");
        }
        if (taskList.get(Integer.parseInt(newInput.getParam()) - 1).getStatus()) {
            throw new dukeException("Already marked as done.");
        }

        taskList.get(Integer.parseInt(newInput.getParam()) - 1).markDone();
        ui.printMarkDone(taskList.get(Integer.parseInt(newInput.getParam()) - 1).getDescription());
    }

    private void deleteTask(input newInput) throws dukeException{
        if (newInput.getParam().equals("")) {
            throw new dukeException("Please enter a number.");
        }
        if (!newInput.getParam().matches("-?(0|[1-9]\\d*)")) {
            throw new dukeException("Please enter a number");
        }
        if ((Integer.parseInt(newInput.getParam())) > numTasks) {
            throw new dukeException("Sorry, but that task does not exist.");
        }

        String deltedTaskDesc = taskList.get((Integer.parseInt(newInput.getParam()) - 1)).getListInfo();
        taskList.remove((Integer.parseInt(newInput.getParam()) - 1));
        numTasks--;
        ui.printDelete(deltedTaskDesc, numTasks);
    }

    private void exitProgram() {
        exitFlag = true;
        ui.printExitProgram();
    }
}
