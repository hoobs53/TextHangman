package controller;

import model.GameModel;
import view.GameView;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private final GameView view;
    private final GameModel model;

    private char userChoice = 'y'; //initial value
    public GameController() {
        this.view = new GameView();
        this.model = new GameModel();
        while(Character.toLowerCase(userChoice) == 'y')
            gameLoop();

        // game ended
        view.displayExitView();
    }
    public void gameLoop() {
        String userInput;
        char guessChar;
        boolean matched;
        boolean win, lose;

        model.initGameWord();

        List<Character> alreadyGuessedChars = model.getAlreadyGuessedChars();
        view.displayWelcomeView(model.getCurrentGuesses());
        Scanner input = new Scanner(System.in);


        while(true) {
            userInput = input.next();
            guessChar = userInput.charAt(0); // first letter of input
            guessChar = Character.toLowerCase(guessChar);
            if (! alreadyGuessedChars.contains(guessChar)) {
                matched = model.checkForLetter(guessChar);
                alreadyGuessedChars = model.getAlreadyGuessedChars();
                view.displayGuessResult(matched, model.getLives());
                win = model.checkIfWon();
                lose = model.checkIfLost();
                if (win) {
                   view.displayWin(model.getLives(), model.getAttempts(), model.getWord());
                   break;
                }
                if (lose) {
                    view.displayLose(model.getWord());
                    break;
                }
                view.displayNextRound(model.getCurrentGuesses(), model.getAlreadyGuessedChars());
            }
            else view.displayWrongGuess(Character.isLetter(guessChar));
        }
        // check if user wants to keep playing [y/else]
        userInput = input.next();
        userChoice = userInput.charAt(0); // first letter of input
    }

}
