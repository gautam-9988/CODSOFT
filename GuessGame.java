//Java Program of Guess Game
/*  
The "Guessing Game" is an interactive and engaging activity where a player tries to guess a randomly selected number within a given range. The player is provided with feedback after each guess, indicating whether the guess is correct, too high, or too low. The primary objective is for the player to narrow down their guesses and ultimately identify the correct number. The game often incorporates elements such as limiting the number of attempts, tallying scores based on successful guesses, and offering the option to play multiple rounds. The game's simplicity, coupled with the challenge of deducing the hidden number, makes it a popular choice for both individual enjoyment and social interaction.
*/


import java.util.Scanner;//These lines import the necessary classes from the java.util package. The Scanner class is used to take user input, and the Random class is used to generate random numbers.
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {// entry of program where game logic is implemented
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        // lowerBound and upperBound define the range of numbers that user need to guess
        int lowerBound = 1;
        int upperBound = 100;
        int maxAtt = 10;// this is the maximum attempt user can take
        int score = 0;//Tells the number of match user has won

        boolean playAgain = true;

        System.out.println("Welcome to the Guessing Game!");

        while (playAgain) {
            int targetNumber = ran.nextInt(upperBound - lowerBound + 1) + lowerBound;// targetNumber is generated
                                                                                     // which i have to guess
            int att = 0;// Further apply the condition of maximum attempts

            System.out.println(
                    "I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            while (att < maxAtt) { // loop until attempts are less then the maximum attempts
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                att++;

                if (userGuess == targetNumber) {// if the number is correctly guessed
                    System.out.println("Congratulations! You've guessed the number in " + att + " attempts.");
                    score++;
                    break;
                } else if (userGuess < targetNumber) {// if guessed number is smaller then the target Number
                    System.out.println("Your guess is too low. Try again.");
                } else {// if the guess number is higer then target number
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (att >= maxAtt) {// if the user has crossed the maximum attempt value then this message will be
                                // printed
                System.out.println(
                        "Sorry, you've reached the maximum number of attempts. The number was " + targetNumber + ".");
            }

            System.out.print("Want to play again. Types 'yes' if want to play and 'no' if don't want to: ");
            String playAgainResponse = sc.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");// If the user types "yes" then playAgain value becomes true and
                                                        // the while loop continues
        }

        System.out.println("Thanks for playing! Your total score is: " + score);//total score is the number of total match won
        sc.close(); // It closes the Scanner and allows Java to reclaim the Scanner's memory.
    }
}