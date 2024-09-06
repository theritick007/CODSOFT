import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuessingGame {
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

        // Check if the user input is an integer
        if (scanner.hasNextInt()) {
            int userGuess = scanner.nextInt();

            // Close the scanner
            scanner.close();

            // Validate user input is within the range
            if (userGuess < min || userGuess > max) {
                System.out.println("The guess must be between " + min + " and " + max + ".");
            } else {
                // Compare the user's guess with the random number and provide feedback
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. The correct number was: " + randomNumber);
                } else {
                    System.out.println("Your guess is too high. The correct number was: " + randomNumber);
                }
            }
        } else {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // Clear the invalid input
        }
    }
}
