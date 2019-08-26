/**
 * parser.java
 * parser object to handle user input
 * call constructor in Duke.java
 */

package parser;

import tasks.*;

import java.io.FileNotFoundException;
import java.util.*;
import common.*;
import ui.*;
import storage.*;

public class parser {
    private String input = "";
    //private ArrayList<task> taskList = new ArrayList<task>(0);
    private ArrayList<task> taskList;
    private ArrayList<String> taskListStorage = new ArrayList<String>(0);
    private int numTasks = 0;
    private int numTasksDone = 0;
    private boolean exitFlag = false;
    private storage localStorage = new storage();

    private textGUI ui = new textGUI();

    public parser() throws dukeException, FileNotFoundException {
        taskList = localStorage.fetchStorage();
        numTasks = taskList.size();
        for (task i: taskList) {
            if (i.getStatus()) numTasksDone++;
        }
        ui.printNumTasks(numTasks, numTasksDone);
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

    private void addToDo(input newInput) throws dukeException {
        if (!newInput.getInput().equals("")) {
            taskList.add(new toDo(newInput.getInput()));
            taskListStorage.add("T / 0 / " + newInput.getInput());
            numTasks++;
            ui.printAddToDo(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
        }
    }

    private void addEvent(input newInput) throws dukeException {
        if (!newInput.getInput().equals("")) {
            event newEvent = new event(newInput.getInput());
            taskList.add(newEvent);
            taskListStorage.add("E / 0 / " + newEvent.getDescription() + " / " + newEvent.getDate());
            numTasks++;
            ui.printAddEvent(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
        }
    }

    private void addDeadline(input newInput) throws dukeException{
        if (!newInput.getInput().equals("")) {
            deadline newDeadline = new deadline(newInput.getInput());
            taskList.add(newDeadline);
            taskListStorage.add("D / 0 / " + newDeadline.getDescription() + " / " + newDeadline.getDate());
            numTasks++;
            ui.printAddDeadline(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
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
        localStorage.saveTaskList(taskList);
        numTasksDone++;
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
        localStorage.saveTaskList(taskList);
        numTasks--;
        ui.printDelete(deltedTaskDesc, numTasks);
    }

    private void exitProgram() {
        exitFlag = true;
        ui.printExitProgram();
    }
}
