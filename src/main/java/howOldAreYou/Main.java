package howOldAreYou;

// import javafx.*;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int age = getUserAge();
        System.out.println("Sua idade: " + age);
        System.out.println("Você já viveu por " + (age * 365) + " dias!");
        System.out.println("Ou " + (age * 52) + " semanas!");
        System.out.println("Em meses, dá " + (age * 12) + " meses vividos!");
        System.out.println("Parando pra pensar, tu viveu " + (age * 4) + " estações do ano.");
    }

    public static int getUserAge() {
        int age;
        while (true) {
            System.out.print("Digite sua idade em anos: ");
            if (SCANNER.hasNextInt()) {
                age = SCANNER.nextInt();
                SCANNER.nextLine(); // consome o enter
                if (age >= 0)
                    return age;
                else
                    System.out.println("Insira uma idade positiva!");
            } else {
                System.out.println("Digite apenas números!");
                SCANNER.nextLine(); // descarta o input inválido
            }
        }
    }
}
