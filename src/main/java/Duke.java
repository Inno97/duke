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
        String command; //user command
        String commandType; //lowercase command
        boolean exitFlag = false;

        //duke level 1-1 greet, echo, exit
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");

        while (!exitFlag) {
            command = sc.nextLine();

            //parse command
            commandType = command.toLowerCase();

            switch(commandType) {
                case "bye": //quit the program
                    exitFlag = true;
                    System.out.println("--------------------------------------------------");
                    System.out.println("Bye. Hope to see you again soon!");
                    System.out.println("--------------------------------------------------");

                    break;
                default:
                    //echo the input for now
                    System.out.println("--------------------------------------------------");
                    System.out.println(command);
                    System.out.println("--------------------------------------------------");

                    break;
            }

        }


    }
}


