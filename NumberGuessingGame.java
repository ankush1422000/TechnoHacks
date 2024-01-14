import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int secretNumber = random.nextInt(100) + 1;

        // Initialize variables
        int attempts = 0;
        int guessedNumber = 0;

        System.out.println("Welcome to the Number Guessing Game! Guess a number between 1 and 100.");

        while (guessedNumber != secretNumber) {
            try {
                // Get user input
                System.out.print("Enter your guess: ");
                guessedNumber = scanner.nextInt();

                // Increment attempts
                attempts++;

                // Provide hints
                if (guessedNumber < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guessedNumber > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + attempts + " attempts.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
