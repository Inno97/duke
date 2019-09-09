/**
 *  input.java
 *  handles the construction and parsing of inputs for duke
 */

package parser;

enum Command {
    TODO, EVENT, DEADLINE, LIST, DONE, FIND, DELETE, BYE, UNKNOWN;
}

/**
 * the input class
 * Handles 
 */
public class input {
    protected String input;
    protected String param;
    protected Command command;

    //construct and parse on the spot
    public input(String inputString) {
        this.input = inputString;
        String inputParsed[] = inputString.split(" ", 2);
        this.command = parseCommand(inputParsed[0]);

        if (inputParsed.length == 1) {
            this.param = ""; //keep empty for now
        } else {
            this.param = inputParsed[1];
        }
    }

    private Command parseCommand (String input) {
        Command command;

        switch(input.toLowerCase()) {
            case "todo":
                command = Command.TODO;
                break;

            case "event":
                command = Command.EVENT;
                break;

            case "deadline":
                command = Command.DEADLINE;
                break;

            case "list":
                command = Command.LIST;
                break;

            case "done":
                command = Command.DONE;
                break;

            case "delete":
                command = Command.DELETE;
                break;

            case "find":
                command = Command.FIND;
                break;

            case "bye":
                command = Command.BYE;
                break;

            default:
                command = Command.UNKNOWN;
                break;
        }

        return command;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setParam(String input) {
        this.param = input;
    }

    public String getInput() {
        return this.input;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getParam() { return this.param; }
}
