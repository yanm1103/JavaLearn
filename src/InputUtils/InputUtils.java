package InputUtils;

import java.util.Scanner;

public class InputUtils {

        /**
     * Receives user input using Scanner, trying to prevent common problems like
     * empty strings
     * 
     * @param type the type of input the caller is expecting
     * @param msg  what to show in the log message
     * @return the user input
     * @deprecated use getStringInput or getIntInput instead
     */
    @Deprecated
    public static String getUserInput(String type, String msg) {
        System.out.println(msg);
        String userInput = "";
        while (userInput.length() == 0) {
            userInput = SYSTEM_SCANNER.nextLine(); // Reading user input here
            if (userInput.length() == 0)
                System.out.println("Por favor, insira um texto.");
            if (type.equals("int")) {
                SYSTEM_SCANNER.nextLine(); // Clear input
                try {
                    Integer.parseInt(userInput);
                } catch (Exception e) {
                    System.out.println("Por favor, insira um número inteiro.");
                    userInput = "";
                }
            }
        }
        return userInput;
    }

    /**
     * Reads a string input from the user
     * @param message the message to show to the user
     * @return the string input from the user
     */
    public static String getStringInput(String message) {
        System.out.println(message);
        String userInput = "";
        while (userInput.length() == 0) {
            userInput = SYSTEM_SCANNER.nextLine(); // Reading user input here
            if (userInput.length() == 0)
                System.out.println("Por favor, insira um texto.");
        }
        return userInput;
    }

    /**
     * Reads an integer input from the user
     * @param message the message to show to the user
     * @return the integer input from the user
     */
    public static int getIntInput(String message) {
        System.out.println(message);
        while (true) {
            try {
                int value = SYSTEM_SCANNER.nextInt();
                SYSTEM_SCANNER.nextLine(); // consume the rest of the line/newline
                return value;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro.");
                SYSTEM_SCANNER.nextLine(); // clear invalid token
            }
        }
    }

    private static final Scanner SYSTEM_SCANNER = new Scanner(System.in);

}
