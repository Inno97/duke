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

/**
 * the search engine class
 * handles searching using the "find" command
 */
public class searchEngine {
    private ArrayList<String> searchedList = null;
    private ui ui = new ui();
    private String searchMessage = null;

    public searchEngine() {
    }

    /**
     * Searches for tasks and updates the searched list
     * @param taskList the current task list of Duke
     * @param query the query keyword to find
     */
    public void searchForTasks(taskList taskList, input query) {
        String queryString = query.getParam();
        ArrayList<task> searchList = new ArrayList<task>(0);
        searchList = populateSearchList(taskList.getTaskList(), query.getParam());
        ui.printSearchResults(searchList);
        searchMessage = ui.getSearchResults(searchList);
    }

    /**
     * Finds all items in task list with query
     * @param taskList the task list of Duke
     * @param query the query keyword to find
     * @return the search list for Duke to use
     */
    private ArrayList<task> populateSearchList(ArrayList<task> taskList, String query) {
        ArrayList<task> searchList = new ArrayList<task>(0);
        for (task i: taskList) {
            if (i.getDescription().contains(query)) {
                searchList.add(i);
            }
        }

        return searchList;
    }

    /**
     * Gets the message that Duke should show
     * @return message the message that Duke should show
     */
    public String getSearchMessage() {
        return searchMessage;
    }
}