/**
 * textGUI.java
 * class handles all ui-related methods
 * call constructor at Duke.java
 */

package ui;

import tasks.task;

import java.util.ArrayList;

public class ui {

    public ui() {
    }

    public void printWelcome() {
        //welcome screen
        String logo = "=================================================\n"
                + "  ____        _        \n"
                + " |  _ \\ _   _| | _____ \n"
                + " | | | | | | | |/ / _ \\\n"
                + " | |_| | |_| |   <  __/\n"
                + " |____/ \\__,_|_|\\_\\___|\n"
                + "=================================================";
        //System.out.println("Hello from\n" + logo);
        System.out.println(logo);
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
    }

    public void printNumTasks(int numTasks, int numCompleted) {
        System.out.println("--------------------------------------------------");
        System.out.println(" You currently have:");
        System.out.println(" " + numTasks + " Tasks in Total and " + numCompleted + " Tasks Completed.");
        System.out.println("--------------------------------------------------");
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

    public void printSearchResults(ArrayList<task> searchList) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Here are the matching tasks in your list:");
        if (searchList.size() != 0) {
            int taskIndex = 0;
            for (task newTask : searchList) {
                System.out.println((taskIndex + 1) + ". " + newTask.getListInfo());
                taskIndex++;
            }
        } else {
            System.out.println("There are no matching tasks in your list.");
        }
        System.out.println("--------------------------------------------------");
    }

    public void printDelete(String description, int numTasksLeft) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Noted. I've removed this task: ");
        System.out.println("   " + description);
        System.out.println("Now you have " + numTasksLeft + " tasks in the list.");
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

    public String getWelcome() {
        String message = "==================================\n"
                + "  ____        _        \n"
                + " |    _ \\  _    _| | _____ \n"
                + " |  | |  |  | |  | |/ / _ \\\n"
                + " |  |_|  |  |_|  |   <  __/\n"
                + " |____/ \\ __,_|_|\\_\\___|\n"
                + "==================================\n"
                + " Hello! I'm Duke\n"
                + " What can I do for you?";
        return message;
    }

    public String getNumTasks(int numTasks, int numCompleted) {
        String message = "----------------------------------\n"
                + " You currently have:\n"
                + " " + numTasks + " Tasks in Total and " + numCompleted + " Tasks Completed.\n"
                + "----------------------------------";
        return message;
    }

    public String getTasks(ArrayList<task> taskList) {
        String message = "--------------------------------------------------\n"
                + "Here are the tasks in your list:\n";

        int taskIndex = 0;
        for (task newTask : taskList) {
            message += (" " + (taskIndex + 1) + ". " + newTask.getListInfo() + "\n");
            taskIndex++;
        }

        message += "--------------------------------------------------";
        return message;
    }

    public String getAddToDo(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Todo: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getAddEvent(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Event: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getAddDeadline(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Deadline: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getMarkDone(String description) {
        String message = "--------------------------------------------------\n"
                + "Nice! I've marked this task as done:\n"
                + "[✓] " + description + "\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getSearchResults(ArrayList<task> searchList) {
        String message = "--------------------------------------------------\n"
                + " Here are the matching tasks in your list:\n";

        if (searchList.size() != 0) {
            int taskIndex = 0;
            for (task newTask : searchList) {
                message += (" " + (taskIndex + 1) + ". " + newTask.getListInfo() + "\n");
                taskIndex++;
            }
        } else {
            message += "There are no matching tasks in your list.\n";
        }

        message += "--------------------------------------------------";
        return message;
    }

    public String getDelete(String description, int numTasksLeft) {
        String message = "--------------------------------------------------\n"
                + " Noted. I've removed this task: \n"
                + "   " + description + "\n"
                + "Now you have " + numTasksLeft + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getExitProgram() {
        String message = "--------------------------------------------------\n"
                + "Bye. Hope to see you again soon!\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getException(String error) {
        String message = "--------------------------------------------------\n"
                + error + "\n"
                + "--------------------------------------------------";
        return message;
    }

    public String getError() {
        String message = "--------------------------------------------------\n"
                + "There's an issue that caused the action to fail."
                + "Please try again..."
                + "--------------------------------------------------";
        return message;
    }
}
