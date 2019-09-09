import common.dukeException;
import duke.Duke;
import org.junit.jupiter.api.Test;
import parser.input;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DukeTest {
    Duke testDuke = new Duke();

    public DukeTest() throws FileNotFoundException, dukeException {
    }

    /**
     * Checks if the welcome message can be fetched properly by Duke
     */
    @Test
    public void testWelcomeMessage() {
        assertEquals("==================================\n"
                + "  ____        _        \n"
                + " |    _ \\  _    _| | _____ \n"
                + " |  | |  |  | |  | |/ / _ \\\n"
                + " |  |_|  |  |_|  |   <  __/\n"
                + " |____/ \\ __,_|_|\\_\\___|\n"
                + "==================================\n"
                + " Hello! I'm Duke\n"
                + " What can I do for you?"
                , testDuke.getWelcome());
    }

    /**
     * Checks if a To Do is added properly
     */
    @Test
    public void addToDo() throws dukeException {
        testDuke.parseRequest("todo this is a sample To Do.");
        assertEquals("--------------------------------------------------\n"
                + " Got it. I've added this Todo: \n"
                + " " + "this is a sample To Do." + "\n"
                + " Now you have " + testDuke.getNumTasks() + " tasks in the list.\n"
                + "--------------------------------------------------"
                , testDuke.fetchMessage());
    }

    /**
     * Checks if an item can be deleted properly
     */
    @Test
    public void deleteLatestItem() throws dukeException {
        testDuke.parseRequest("delete " + testDuke.getNumTasks());
        assertEquals("--------------------------------------------------\n"
                + " Noted. I've removed this task: \n"
                + "   " + "[T] [âœ—] todo this is a sample To Do" + "\n"
                + "Now you have " + testDuke.getNumTasks() + " tasks in the list.\n"
                + "--------------------------------------------------"


                , testDuke.fetchMessage());
    }

}