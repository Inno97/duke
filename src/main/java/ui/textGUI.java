/**
 * textGUI.java
 * class handles all ui-related methods
 * call constructor at Duke.java
 */

package ui;

import tasks.task;

import java.util.ArrayList;

public class textGUI {

    public textGUI() {
    }

    public void printWelcome() {
        //welcome screen
        String logo = "=================================================\n"
                + "  ____        _        \n"
                + " |  _ \\ _   _| | _____ \n"
                + " | | | | | | | |/ / _ \\\n"
                + " | |_| | |_| |   <  __/\n"
                + " |____/ \\__,_|_|\\_\\___|\n"
                + "=================================================\n";
        //System.out.println("Hello from\n" + logo);
        System.out.println(logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public void printTasks(ArrayList<task> taskList) {
        System.out.println("--------------------------------------------------");
        System.out.println("Here are the tasks in your list:");
        int taskIndex = 0;
        for (task newTask : taskList) {
            System.out.println((taskIndex + 1) + ". " + newTask.getListInfo());
            taskIndex++;
        }
        System.out.println("--------------------------------------------------");
    }

    public void printAddToDo(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Todo: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    public void printAddEvent(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Event: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    public void printAddDeadline(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Deadline: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    public void printMarkDone(String description) {
        System.out.println("--------------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[✓] " + description);
        System.out.println("--------------------------------------------------");
    }

    public void printExitProgram() {
        System.out.println("--------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("--------------------------------------------------");
    }

    public void printException(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------------------------");
    }
}
