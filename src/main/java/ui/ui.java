/**
 * textGUI.java
 * class handles all ui-related methods
 * call constructor at Duke.java
 */

package ui;

import tasks.task;

import java.util.ArrayList;

/**
 * The ui class
 * Handles Duke's UI
 * Can switch between text UI (printXXXX) and GUI (getXXXX)
 * printXXXX will print out in console
 * getXXXX will return a string to Duke
 */
public class ui {
    /**
     * The ui class constructor
     * construct as an object to call the methods
     */
    public ui() {
    }

    /**
     * Prints the welcome message
     */
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

    /**
     * Prints the current number of tasks and completed tasks
     * @param numTasks the total number of tasks
     * @param numCompleted the total number of tasks completed
     */
    public void printNumTasks(int numTasks, int numCompleted) {
        System.out.println("--------------------------------------------------");
        System.out.println(" You currently have:");
        System.out.println(" " + numTasks + " Tasks in Total and " + numCompleted + " Tasks Completed.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the list of tasks
     * @param taskList the taskList
     */
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

    /**
     * Prints the message shown when a To Do item is added
     * @param newTask the new To Do that is added
     * @param numTasks the total number of tasks
     */
    public void printAddToDo(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Todo: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the message shown when an Event item is added
     * @param newTask the new Event that is added
     * @param numTasks the total number of tasks
     */
    public void printAddEvent(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Event: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the message shown when a Deadline item is added
     * @param newTask the new Deadline that is added
     * @param numTasks the total number of tasks
     */
    public void printAddDeadline(task newTask, int numTasks) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Got it. I've added this Deadline: ");
        System.out.println(" " + newTask.getDescription());
        System.out.println(" Now you have " + numTasks + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the message shown when an item is marked as done
     * @param description the description of the item that is marked done
     */
    public void printMarkDone(String description) {
        System.out.println("--------------------------------------------------");
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[✓] " + description);
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the search results from the find function
     * @param searchList the search results
     */
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

    /**
     * Prints the message shown when an item is deleted successfully
     * @param description the description of the deleted item
     * @param numTasksLeft the number of tasks left
     */
    public void printDelete(String description, int numTasksLeft) {
        System.out.println("--------------------------------------------------");
        System.out.println(" Noted. I've removed this task: ");
        System.out.println("   " + description);
        System.out.println("Now you have " + numTasksLeft + " tasks in the list.");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints the exit message
     */
    public void printExitProgram() {
        System.out.println("--------------------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Prints out any exceptions
     * @param message the exception that is thrown
     */
    public void printException(String message) {
        System.out.println("--------------------------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------------------------");
    }

    /**
     * Fetches the welcome message for Duke to use
     * @return message The welcome message
     */
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

    /**
     * Fetches the message telling how many tasks and completed tasks we have
     * @param numTasks the total number of tasks
     * @param numCompleted the total number of tasks completed
     * @return the message that Duke is supposed to get
     */
    public String getNumTasks(int numTasks, int numCompleted) {
        String message = "----------------------------------\n"
                + " You currently have:\n"
                + " " + numTasks + " Tasks in Total and " + numCompleted + " Tasks Completed.\n"
                + "----------------------------------";
        return message;
    }

    /**
     * Fetches the list of tasks we have
     * @param taskList the taskList
     * @return the message that Duke is supposed to get
     */
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

    /**
     * Fetches the message shown when a To Do item is added
     * @param newTask the new To Do item that is added
     * @param numTasks the total number of tasks
     * @return the message that Duke is supposed to get
     */
    public String getAddToDo(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Todo: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown when an Event item is added
     * @param newTask the new Event that is added
     * @param numTasks the total number of tasks
     * @return the message that Duke is supposed to get
     */
    public String getAddEvent(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Event: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown when a Deadline item is added
     * @param newTask the new Deadline that is added
     * @param numTasks the total number of tasks
     * @return the message that Duke is supposed to get
     */
    public String getAddDeadline(task newTask, int numTasks) {
        String message = "--------------------------------------------------\n"
                + " Got it. I've added this Deadline: \n"
                + " " + newTask.getDescription() + "\n"
                + " Now you have " + numTasks + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown when an item is marked as done
     * @param description the description of the item
     * @return the message that Duke is supposed to get
     */
    public String getMarkDone(String description) {
        String message = "--------------------------------------------------\n"
                + "Nice! I've marked this task as done:\n"
                + "[✓] " + description + "\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown for the find function
     * @param searchList the results found
     * @return the message that Duke is supposed to get
     */
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

    /**
     * Fetches the message shown when an item is deleted
     * @param description the description of the item deleted
     * @param numTasksLeft the number of tasks left in taskList
     * @return the message that Duke is supposed to get
     */
    public String getDelete(String description, int numTasksLeft) {
        String message = "--------------------------------------------------\n"
                + " Noted. I've removed this task: \n"
                + "   " + description + "\n"
                + "Now you have " + numTasksLeft + " tasks in the list.\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the exit message
     * @return the message that Duke is supposed to get
     */
    public String getExitProgram() {
        String message = "--------------------------------------------------\n"
                + "Bye. Hope to see you again soon!\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown when an exception occurs
     * @param error the exception that is thrown
     * @return the message that Duke is supposed to get
     */
    public String getException(String error) {
        String message = "--------------------------------------------------\n"
                + error + "\n"
                + "--------------------------------------------------";
        return message;
    }

    /**
     * Fetches the message shown when any error occurs
     * @return message the message that Duke is supposed to get
     */
    public String getError() {
        String message = "--------------------------------------------------\n"
                + "There's an issue that caused the action to fail."
                + "Please try again..."
                + "--------------------------------------------------";
        return message;
    }
}
