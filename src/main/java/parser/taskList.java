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

public class taskList {
    private String input = "";
    private ArrayList<task> taskList;
    private ArrayList<String> taskListStorage = new ArrayList<String>(0);
    private int numTasks = 0;
    private int numTasksDone = 0;
    private boolean exitFlag = false;
    private storage localStorage = new storage();
    private ui ui = new ui();

    private String dukeMessage = null; //return message that duke is supposed to send

    public taskList() throws dukeException, FileNotFoundException {
        taskList = localStorage.fetchStorage();
        numTasks = taskList.size();
        for (task i: taskList) {
            if (i.getStatus()) numTasksDone++;
        }
        ui.printNumTasks(numTasks, numTasksDone);
    }

    public void printTasks() {
        ui.printTasks(taskList);
    }

    public ArrayList<task> getTaskList() {
        return taskList;
    }

    private void setDukeMessage(String message) { dukeMessage = message; }

    private void resetDukeMessage() { dukeMessage = ""; }

    public String getDukeMessage() {
        String message = dukeMessage;
        resetDukeMessage();
        return message;
    }

    public void getTasks() {
        dukeMessage = ui.getTasks(taskList);
    }

    public void addToDo(input newInput) throws dukeException {
        if (!newInput.getInput().equals("")) {
            taskList.add(new toDo(newInput.getInput()));
            taskListStorage.add("T / 0 / " + newInput.getInput());
            numTasks++;
            //ui.printAddToDo(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
            setDukeMessage(ui.getAddToDo(taskList.get(numTasks - 1), numTasks));
        }
    }

    public void addEvent(input newInput) throws dukeException {
        if (!newInput.getInput().equals("")) {
            event newEvent = new event(newInput.getInput());
            taskList.add(newEvent);
            taskListStorage.add("E / 0 / " + newEvent.getDescription() + " / " + newEvent.getDate());
            numTasks++;
            //ui.printAddEvent(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
            setDukeMessage(ui.getAddEvent(taskList.get(numTasks - 1), numTasks));
        }
    }

    public void addDeadline(input newInput) throws dukeException{
        if (!newInput.getInput().equals("")) {
            deadline newDeadline = new deadline(newInput.getInput());
            taskList.add(newDeadline);
            taskListStorage.add("D / 0 / " + newDeadline.getDescription() + " / " + newDeadline.getDate());
            numTasks++;
            //ui.printAddDeadline(taskList.get(numTasks - 1), numTasks);
            localStorage.saveTaskList(taskList);
            setDukeMessage(ui.getAddDeadline(taskList.get(numTasks - 1), numTasks));
        }
    }

    public void markAsDone(input newInput) throws dukeException{
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
        //ui.printMarkDone(taskList.get(Integer.parseInt(newInput.getParam()) - 1).getDescription());
        localStorage.saveTaskList(taskList);
        numTasksDone++;
        setDukeMessage(ui.getMarkDone(taskList.get(Integer.parseInt(newInput.getParam()) - 1).getDescription()));
    }

    public void deleteTask(input newInput) throws dukeException{
        if (newInput.getParam().equals("")) {
            throw new dukeException("Please enter a number.");
        }
        if (!newInput.getParam().matches("-?(0|[1-9]\\d*)")) {
            throw new dukeException("Please enter a number");
        }
        if ((Integer.parseInt(newInput.getParam())) > numTasks || (Integer.parseInt(newInput.getParam()) <= 0)) {
            throw new dukeException("Sorry, but that task does not exist.");
        }

        String deletedTaskDesc = taskList.get((Integer.parseInt(newInput.getParam()) - 1)).getListInfo();
        taskList.remove((Integer.parseInt(newInput.getParam()) - 1));
        localStorage.saveTaskList(taskList);
        numTasks--;
        //ui.printDelete(deletedTaskDesc, numTasks);
        setDukeMessage(ui.getDelete(deletedTaskDesc, numTasks));
    }
}
