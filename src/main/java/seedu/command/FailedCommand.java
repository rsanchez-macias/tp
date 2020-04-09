package seedu.command;

import seedu.common.Constants;
import seedu.exception.ProjException;

public class FailedCommand extends Command {

    private String feedback = "";

    private static final String WRONG_ARGUMENT = "Wrong number of arguments";

    /**
     * Constructor method for custom error message.
     * @param commandName command name
     * @param feedback message to display
     */
    // for error with unique feedback
    public FailedCommand(String commandName, String feedback) {
        feedback += String.format("[Error][%s]: ", commandName);
        this.feedback = feedback;
        this.feedback += Constants.NEW_LINE;
    }

    /**
     * Constructor method for wrong argument count, used in parser class.
     * @param commandName command name
     * @param userArgumentCount arguments user arguments
     * @param expectedCount expected arguments for command
     */
    // for error with arg error
    public FailedCommand(String commandName, int userArgumentCount, String expectedCount) {
        feedback += String.format("[Error][%s]: %s,\nReceived: %d Expected: %s\n",
                commandName, WRONG_ARGUMENT, userArgumentCount, expectedCount);
    }

    @Override
    public CommandResult execute() throws ProjException {
        return new CommandResult(feedback);
    }
}