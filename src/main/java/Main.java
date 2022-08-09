import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many character token do you want to generate? You can choose between 5, 10 or 15.");
        int charactersNumber = new Scanner(System.in).nextInt();

        if (Arrays.asList(5, 10, 15).contains(charactersNumber)) {
            System.out.println("Your generated token: " + tokenGenerator(charactersNumber));
        } else {
            System.out.println("Sorry, you entered the wrong number. The number must be 5, 10 or 15.");
        }

    }

    public static String tokenGenerator(int charactersNumber) {
        char[] asciiNumbers = new char[charactersNumber];
        String token = "";
        char[] excludedAsciiNumbers = {34, 39, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 92, 93, 95, 96};

        for (int i = 0; i < asciiNumbers.length; i++) {
            asciiNumbers[i] = (char) (new Random().nextInt(123 - 33) + 33);
            if (String.valueOf(excludedAsciiNumbers).contains("" + asciiNumbers[i])) {
                token += tokenGenerator(1);
            } else {
                token += asciiNumbers[i];
            }
        }

        return token;
    }
}
