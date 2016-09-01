package seedu.addressbook.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;

/**
 * Text UI of the application.
 */
public class TextUi {

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

    private Formatter format;
    
    private final Scanner in;

    public TextUi(){
        this(System.in, System.out);
    }

    public TextUi(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        format = new Formatter(out);
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
    	format.printEnterCommand();
        String fullInputLine = in.nextLine();

        // silently consume all ignored lines
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }

        format.showUserCommandEntered(fullInputLine);
        return fullInputLine;
    }


    public void showWelcomeMessage(String version, String storageFilePath) {
    	format.printWelcomeMessage(version, storageFilePath);
    }

    public void showGoodbyeMessage() {
    	format.printGoodbyeMessage();
    }


    public void showInitFailedMessage() {
    	format.printInitFailMessage();
    }


    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
    	format.printResultToUser(result);
    }

	public void showToUser(String message) {
		format.showToUser(message);
	}

}
