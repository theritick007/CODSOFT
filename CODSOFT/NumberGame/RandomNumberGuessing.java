import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuessing {
    public static void main(String[] args) {
        // Define the range
        int min = 1;
        int max = 100;

        // Create an instance of Random
        Random random = new Random();
        
        // Generate a random number within the specified range
        int randomNumber = random.nextInt(max - min + 1) + min;

        // Create an instance of Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their guess
        System.out.print("Enter your guess (between " + min + " and " + max + "): ");
        int userGuess = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Compare the user's guess with the random number and provide feedback
        if (userGuess == randomNumber) {
            System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
        } else {
            System.out.println("Sorry, the correct number was: " + randomNumber);
        }
    }
}
