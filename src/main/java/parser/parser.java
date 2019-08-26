package parser;

import tasks.*;
import java.util.*;

public class parser {
    private String input = "";
    private ArrayList<task> taskList = new ArrayList<task>(0);
    private int numTasks = 0;
    private boolean exitFlag = false;

    public parser() {
    }

    //handle input
    public void parseInput(input newInput) {
        switch(newInput.getCommand()) {
            case "todo":
                //assign to toDo
                addToDo(newInput);
                break;

            case "event":
                //assign to event
                addEvent(newInput);
                break;

            case "deadline":
                //assign to deadline
                addDeadline(newInput);
                break;

            case "list":
                printTasks();
                break;

            case "done":
                markAsDone(newInput);
                break;

            case "bye":
                exitProgram();
                break;

            default:
                break;
        }
    }

    public boolean getExitStatus() {
        return this.exitFlag;
    }

    private void printTasks() {
        System.out.println("--------------------------------------------------");
        System.out.println("Here are the tasks in your list:");
        int taskIndex = 0;
        for (task newTask : taskList) {
            System.out.println((taskIndex + 1) + ". " + newTask.getListInfo());
            taskIndex++;
        }
        System.out.println("--------------------------------------------------");
    }

    private void addTask(input newInput) {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new task(newInput.getInput()));
            numTasks++;

            System.out.println("--------------------------------------------------");
            System.out.println("added: " + newInput.getInput());
            System.out.println("--------------------------------------------------");
        }
    }

    private void addToDo(input newInput) {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new toDo(newInput.getInput()));
            numTasks++;

            System.out.println("--------------------------------------------------");
            System.out.println(" Got it. I've added this task: ");
            System.out.println(" " + taskList.get(numTasks - 1).getDescription());
            System.out.println(" Now you have " + numTasks + " tasks in the list.");
            System.out.println("--------------------------------------------------");
        }
    }

    private void addEvent(input newInput) {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new event(newInput.getInput()));
            numTasks++;

            System.out.println("--------------------------------------------------");
            System.out.println(" Got it. I've added this task: ");
            System.out.println(" " + taskList.get(numTasks - 1).getDescription());
            System.out.println(" Now you have " + numTasks + " tasks in the list.");
            System.out.println("--------------------------------------------------");
        }
    }

    private void addDeadline(input newInput) {
        if (!newInput.getInput().equals("")) {
            this.taskList.add(new deadline(newInput.getInput()));
            numTasks++;

            System.out.println("--------------------------------------------------");
            System.out.println(" Got it. I've added this task: ");
            System.out.println(" " + taskList.get(numTasks - 1).getDescription());
            System.out.println(" Now you have " + numTasks + " tasks in the list.");
            System.out.println("--------------------------------------------------");
        }
    }

    private void markAsDone(input newInput) {
        if (!newInput.getParam().equals("")) {
            if ((Integer.parseInt(newInput.getParam())) <= numTasks) {
                taskList.get(Integer.parseInt(newInput.getParam()) - 1).markDone();

                System.out.println("--------------------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[✓] " + taskList.get(Integer.parseInt(newInput.getParam()) - 1).getDescription());
                System.out.println("--------------------------------------------------");
            } else { //factor in OOB
                System.out.println("--------------------------------------------------");
                System.out.println("Task does not exist.");
                System.out.println("--------------------------------------------------");

            }
        } else { //empty query, we simply treat this as adding task for now
            taskList.add(new task(newInput.getInput()));
            numTasks++;

            System.out.println("--------------------------------------------------");
            System.out.println("added: " + newInput.getInput());
            System.out.println("--------------------------------------------------");
        }
    }

    private void exitProgram() {
        exitFlag = true;
        System.out.println("--------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("--------------------------------------------------");
    }

}
