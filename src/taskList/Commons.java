package taskList;

/**
 * Generic methods to be used throughout the app.
 */
public class Commons {

    /**
     * Validation for any command that uses a number argument.
     * 
     * @param args a string (likely) containing a number.
     * @return {@code true} or {@code false} depending on if the string can be
     *         converted or not.
     */
    public static boolean checkInt(String args) {
        try {
            Integer.parseInt(args);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    /**
     * Validation for the argument passed.
     * 
     * @param args Should either be empty, or a number (String).
     */
    public static boolean validateArgs(String args, boolean allowEmpty) {
        if (args == null)
            return allowEmpty;
        if (allowEmpty)
            return (args.isEmpty() || Commons.checkInt(args));
        else
            return (!args.isEmpty() && Commons.checkInt(args));
    }

    /**
     * It's expected that commands are {@code command <args>}, so we need to
     * separate the input string.
     * 
     * @param input the raw command with it's args.
     * @return the command without the args.
     */
    public static String getCommandFromInput(String input) {
        String[] parts = input.split(" ", 0);
        return parts[0];
    }

    /**
     * It's expected that commands are {@code command <args>}, so we need to
     * separate the input string.
     * 
     * @param input the raw command with it's args.
     * @return the args without the command.
     */
    public static String getArgsFromCommand(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length > 1)
            return parts[1];
        else
            return "";
    }

    /**
     * Since the user sees the list of tasks starting on one, we'll always need
     * to subtract one from the parameter of which task he wants (by index).
     * 
     * @param args A string the user typed to refer to the task index.
     * @return The number parsed - 1 to account for zero indexing.
     */
    public static int getTaskIndex(String args) {
        return Integer.parseInt(args) - 1;
    }
}
