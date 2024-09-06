import java.util.Scanner;
import java.util.Random;

public class NumberGuessingRounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            // Specify the range and the number of attempts
            int min = 1;
            int max = 100;
            int maxAttempts = 5; // Limit the user to 5 attempts

            // Generate a random number within the specified range
            int targetNumber = random.nextInt(max - min + 1) + min;
            int userGuess = 0;
            int attemptCount = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have selected a number between " + min + " and " + max + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            // Repeat until the user guesses the correct number or runs out of attempts
            while (userGuess != targetNumber && attemptCount < maxAttempts) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attemptCount++;

                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                    break;
                }

                // Inform the user of the remaining attempts
                if (attemptCount < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - attemptCount) + " attempts left.");
                } else {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                }
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}

