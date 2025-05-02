import java.util.Random;
import java.util.Scanner;

public class Number_Guessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;
        int round = 1;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = rand.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + " - Guess a number between 1 and 100:");
            
            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    score += (10 - attempts); 
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! The correct number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (!choice.equals("yes")) {
                break;
            }
            round++;
        }
        System.out.println("Thanks for playing! Final Score: " + score);
        sc.close();
    }
}