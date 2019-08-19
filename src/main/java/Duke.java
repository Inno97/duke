/**
 * duke.java
 * Main app file for duke
 * Comments:
 * For now, we'll keep everything in the main duke.java
 * but we'll split up everything later on
 */

import java.io.*;
import java.util.*;

import tasks.*;

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

        String input; //user input
        String command; //if applicable, split into command and parameter
        String inputParams;

        ArrayList<task> taskList = new ArrayList<task>(0);
        //ArrayList<String> taskList = new ArrayList<String>(0);
        //ArrayList<Boolean> taskStatusList = new ArrayList<Boolean>(0);
        int numTasks = 0;

        //duke level 1-3: mark as done
        //Add the ability to mark tasks as done.
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while (!exitFlag) {
            input = sc.nextLine();

            //parse input
            String inputParsed[] = input.split(" ", 2);
            command = inputParsed[0];
            if (inputParsed.length == 1) {
                inputParams = ""; //keep empty for now
            } else {
                inputParams = inputParsed[1];
            }
            command = command.toLowerCase();

            switch(command) {
                case "list": //list all tasks in duke
                        System.out.println("--------------------------------------------------");
                        for (int i = 0; i < numTasks; i++) {
                            System.out.print((i + 1) + ".[" + taskList.get(i).getStatusIcon() + "] ");
                            System.out.println(taskList.get(i).getDescription());
                        }
                        System.out.println("--------------------------------------------------");

                    break;

                case "done": //mark as done
                    if (!inputParams.equals("")) {
                        if ((Integer.parseInt(inputParams)) <= numTasks) {
                            taskList.get(Integer.parseInt(inputParams) - 1).markDone();

                            System.out.println("--------------------------------------------------");
                            System.out.println("Nice! I've marked this task as done:");
                            System.out.println("[✓] " + taskList.get(Integer.parseInt(inputParams) - 1).getDescription());
                            System.out.println("--------------------------------------------------");
                        } else { //factor in OOB
                            System.out.println("--------------------------------------------------");
                            System.out.println("Task does not exist.");
                            System.out.println("--------------------------------------------------");

                        }
                    } else { //empty query, we simply treat this as adding task for now
                        taskList.add(new task(input));
                        numTasks++;

                        System.out.println("--------------------------------------------------");
                        System.out.println("added: " + input);
                        System.out.println("--------------------------------------------------");
                    }
                    break;

                case "bye": //quit the program
                    exitFlag = true;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("--------------------------------------------------");

                    break;

                default: //add to task list and echo
                    if (!input.equals("")) {
                        taskList.add(new task(input));
                        numTasks++;

                        System.out.println("--------------------------------------------------");
                        System.out.println("added: " + input);
                        System.out.println("--------------------------------------------------");
                    }

                    break;
            }
        }
    }
}
