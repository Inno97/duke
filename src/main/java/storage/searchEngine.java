/**
 * searchEngine.java
 * handles the searching of specific items in the tasklist
 */

package storage;

import parser.input;
import parser.taskList;
import tasks.*;
import java.util.ArrayList;
import ui.*;


public class searchEngine {
    private ArrayList<String> searchedList = null;
    private ui ui = new ui();
    private String searchMessage = null;

    public searchEngine() {
    }

    public void searchForTasks(taskList taskList, input query) {
        String queryString = query.getParam();
        ArrayList<task> searchList = new ArrayList<task>(0);
        searchList = populateSearchList(taskList.getTaskList(), query.getParam());
        ui.printSearchResults(searchList);
        searchMessage = ui.getSearchResults(searchList);
    }

    private ArrayList<task> populateSearchList(ArrayList<task> taskList, String query) {
        ArrayList<task> searchList = new ArrayList<task>(0);
        for (task i: taskList) {
            if (i.getDescription().contains(query)) {
                searchList.add(i);
            }
        }

        return searchList;
    }

    public String getSearchMessage() {
        return searchMessage;
    }
}