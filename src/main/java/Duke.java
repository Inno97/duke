/**
 * duke.java
 * Main app file for duke
 * Comments:
 * For now, we'll keep everything in the main duke.java
 * but we'll split up everything later on
 */

import java.util.*;

public class Duke {
    public static void main(String[] args) {
        //welcome screen
        String logo = "=================================================\n"
                + "  ____        _        \n"
                + " |  _ \\ _   _| | _____ \n"
                + " | | | | | | | |/ / _ \\\n"
                + " | |_| | |_| |   <  __/\n"
                + " |____/ \\__,_|_|\\_\\___|\n"
                + "=================================================\n";
        System.out.println("Hello from\n" + logo);

        //setup scanner
        Scanner sc = new Scanner(System.in);

        //local variables to keep track of
        boolean exitFlag = false;

        String command; //user command
        String commandType; //lowercase command for duke to interpret

        String taskList[]; //store up to 100 tasks for now
        taskList = new String[100];
        int numTasks = 0;

        //duke level 1-2: add, list
        //Add the ability to store whatever text entered by the user and display them back to the user when requested.
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while (!exitFlag) {
            command = sc.nextLine();

            //parse command
            commandType = command.toLowerCase();

            switch(commandType) {
                case "list": //list all tasks in duke
                        System.out.println("--------------------------------------------------");
                        for (int i = 0; i < numTasks; i++) {
                            System.out.println((i + 1) + ". " + taskList[i]);
                        }
                        System.out.println("--------------------------------------------------");

                    break;

                case "bye": //quit the program
                    exitFlag = true;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("--------------------------------------------------");

                    break;

                default:
                    //add to task list and echo
                    taskList[numTasks] = command;
                    numTasks++;

                    System.out.println("--------------------------------------------------");
                    System.out.println("added: " + command);
                    System.out.println("--------------------------------------------------");

                    break;
            }
        }
    }
}


