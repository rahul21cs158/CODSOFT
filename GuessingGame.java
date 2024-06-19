import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;
            System.out.println("\nRound " + rounds + " - Guess the number between " + minRange + " and " + maxRange + "!");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());

                    if (guess < minRange || guess > maxRange) {
                        System.out.println("Please enter a number between " + minRange + " and " + maxRange + ".");
                        continue;
                    }

                    attempts++;

                    if (guess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Congratulations! You've guessed the correct number.");
                        score += maxAttempts - attempts + 1;
                        hasGuessedCorrectly = true;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame over! You've played " + rounds + " rounds with a total score of " + score + " points.");
        scanner.close();
    }
}
  