/**
 *  input.java
 *  handles the construction and parsing of inputs for duke
 */

package parser;

public class input {
    protected String input;
    protected String command;
    protected String param;

    //construct and parse on the spot
    public input(String inputString) {
        this.input = inputString;
        String inputParsed[] = inputString.split(" ", 2);
        this.command = (inputParsed[0]).toLowerCase();

        if (inputParsed.length == 1) {
            this.param = ""; //keep empty for now
        } else {
            this.param = inputParsed[1];
        }
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setCommand(String input) {
        this.command = input;
    }

    public void setParam(String input) {
        this.param = input;
    }

    public String getInput() {
        return this.input;
    }

    public String getCommand() {
        return this.command;
    }

    public String getParam() {
        return this.param;
    }

}
