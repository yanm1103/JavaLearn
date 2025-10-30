package taskList;

/**
 * Generic methods to be used throughout the app.
 */
public class Commons {

    /**
     * Validation for any command that uses a number argument.
     * 
     * @param args a string (probably) containing a number.
     * @return {@code true} or {@code false} depending on if the string can be
     *         converted or not.
     */
    public static boolean checkInt(String args) {
        try {
            Integer.parseInt(args);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validation for the argument passed.
     * 
     * @param args Should either be empty, or a number (String).
     */
    public static boolean validateArgs(String args, boolean allowEmpty) {
        if (args == null) return allowEmpty;
        if (allowEmpty)
            return (args.isEmpty() || Commons.checkInt(args));
        else
            return (!args.isEmpty() && Commons.checkInt(args));
    }

    public static String getCommandFromInput(String input) {
        String[] parts = input.split(" ", 0);
        return parts[0];
    }

    public static String getArgsFromCommand(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length > 1) {
            return parts[1];
        } else {
            return "";
        }
    }
}
