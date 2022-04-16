package view;

import controller.GameController;

import java.util.List;

import static java.sql.Types.NULL;

public class GameView {

    private void displayCurrentGuesses(char[] guesses) {
        System.out.print("Current state: ");
        for (char currentChar : guesses) {
            if (currentChar == NULL) System.out.print("_");
            else System.out.printf("%s", currentChar);
        }
        System.out.print("\n");
    }

    public void displayWin(int lives, int attempts, String word) {
        System.out.println("Congratulations, you have guessed the word: " + word + "!");
        System.out.println("You finished in " + attempts + " guesses.");
        System.out.println("You had " + lives + " lives left.");
        System.out.println("Another round? [Y to keep playing]");
    }

    public void displayExitView() {
        System.out.println("Thanks for playing!");
    }
    public void displayLose(String word) {
        System.out.println("No more lives left.");
        System.out.println("The correct word was: " + word);
        System.out.println("Try again?... [Y to keep playing]");
    }

    private void displayAlreadyGuessed(List<Character> alreadyGuessed) {
        System.out.print("You have already typed letters: ");
        System.out.println(alreadyGuessed);
    }
    public void displayGuessResult(boolean correct, int lives) {
        if (correct) System.out.println("Correct!");
        else {
            System.out.println("Wrong!");
            System.out.println("Lives left: " + lives);
        }
    }

    public void displayNextRound(char[] guesses, List<Character> alreadyGuessedChars) {
        displayAlreadyGuessed(alreadyGuessedChars);
        displayCurrentGuesses(guesses);
        System.out.println("Guess a letter");
    }
    public void displayWelcomeView(char[] guesses) {
        System.out.println("Welcome in text hangman game!");
        System.out.println("The word has been generated.");
        displayCurrentGuesses(guesses);
    }

    public void displayWrongGuess(boolean isChar) {
        if (isChar) System.out.println("You have already typed this letter!");
        else System.out.println("Please type characters");
    }
}
