package usersThatCanDrink;

public class User {
    String name;
    int age;

    static int totalUsers = 0;

    /**
     * User Constructor
     * 
     * @param name will become name
     * @param age  will become age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
        increaseTotalUsers();
    }

    public static void increaseTotalUsers() {
        totalUsers++;
    }

    /**
     * @return If they're 18+ they can drink!
     */
    public boolean canDrink() {
        return age >= 18;
    }

    /**
     * Formats the given name to upper case the first letter and lower case the rest
     * 
     * @param name the original string containing the name
     * @return a new string with the formatted name
     */
    public static String formatName(String name) {
        String firstLetter = name.substring(0, 1).toUpperCase();
        String remainingLetters = name.substring(1).toLowerCase();
        return (firstLetter + remainingLetters).trim(); // I don't want empty spaces in my name
    }
}
