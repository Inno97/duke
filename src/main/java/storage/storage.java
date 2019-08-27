/**
 * storage.java
 * storage class for storing changes locally
 * call constructor at parser.java
 */

package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import tasks.*;
import parser.*;
import common.*;

public class storage {
    private static final String storagePath = "data/tasks.txt";
    private FileReader reader = null;

    public storage() throws dukeException {
        try {
            reader = new FileReader(storagePath);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    //fetch and parse data into local taskList
    public ArrayList<task> fetchStorage() throws dukeException, FileNotFoundException {
        ArrayList<String> data = fetchData();
        ArrayList<task> taskList = parseData(data);

        return taskList;
    }

    //fetch data from local files
    private ArrayList<String> fetchData() throws FileNotFoundException {
        File f = new File(storagePath);
        Scanner sc = new Scanner(f);
        ArrayList<String> data = new ArrayList<String>();

        while (sc.hasNext()) {
            data.add(sc.nextLine());
        }

        return data;
    }

    private ArrayList<task> parseData(ArrayList<String> data) throws dukeException {
        ArrayList<task> taskList = new ArrayList<task>();

        for (String newTask: data) {
            String inputParsed[] = newTask.split(" / ", 4);
            switch(inputParsed[0]) {
                case "T":
                    toDo newToDo = new toDo("toDo " + inputParsed[2]);
                    if (inputParsed[1].equals("1")) newToDo.markDone();
                    taskList.add(newToDo);
                    break;

                case "E":
                    event newEvent = new event("event " + inputParsed[2] + " /at " + inputParsed[3]);
                    if (inputParsed[1].equals("1")) newEvent.markDone();
                    taskList.add(newEvent);
                    break;

                case "D":
                    deadline newDeadline = new deadline("deadline " + inputParsed[2] + " /by " + inputParsed[3]);
                    if (inputParsed[1].equals("1")) newDeadline.markDone();
                    taskList.add(newDeadline);
                    break;
            }
        }

        return taskList;
    }

    public void saveTaskList(ArrayList<task> taskList) throws dukeException {
        File file = new File(storagePath);
        try {
            FileWriter writer = new FileWriter(file);
            for (task newTask : taskList) {
                String line = null;

                switch(newTask.getType().toString()) {
                    case "TODO":
                        line = "T / " + (!newTask.getStatus() ? 0 : 1) + " / " + newTask.getDescription();
                        break;
                    case "EVENT":
                        line = "E / " + (!newTask.getStatus() ? 0 : 1) + " / " + newTask.getDescription() + " / " + ((event) newTask).getDateFormat();
                        break;
                    case "DEADLINE":
                        line = "D / " + (!newTask.getStatus() ? 0 : 1) + " / " + newTask.getDescription() + " / " + ((deadline) newTask).getDateFormat();
                        break;
                }

                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new dukeException("File not found: " + e.getMessage());
        }
    }
}
