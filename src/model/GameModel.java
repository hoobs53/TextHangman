package model;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class GameModel {
    private Word gameWord;
    private char [] currentGuesses;
    private List<Character> alreadyGuessedChars;

    private int lives;
    private int attempts;

    public List<Character> getAlreadyGuessedChars() {
        return alreadyGuessedChars;
    }

    public char[] getCurrentGuesses() {
        return currentGuesses;
    }

    public GameModel() {
        initGameWord();
    }

    public void initGameWord() {
        gameWord = new Word();
        lives = 5;
        attempts = 0;
        currentGuesses = new char [gameWord.getWordLength()];
        alreadyGuessedChars = new ArrayList<>();
    }

    public boolean checkForLetter(char letter) {
        boolean matched = false;
        List<Integer> matchedIndexes = getAllMatchesIndexes(letter);
            for (int ind : matchedIndexes) {
                if (ind == -1) break;
                currentGuesses[ind] = letter;
                if (!matched) matched = true;
            }
        alreadyGuessedChars.add(letter);
        if (!matched ) wrongGuessUpdate();
        attempts += 1;
        return matched;
    }

    public void wrongGuessUpdate() {
        lives -= 1;
    }

    public boolean checkIfWon() {
        for (char currentChar : currentGuesses) {
            if (currentChar == NULL) return false;
        }
        return true;
    }

    public boolean checkIfLost() {
        return lives <= 0;
    }
    private List<Integer> getAllMatchesIndexes(char guess) {
        String currentWord = gameWord.getWord();
        List<Integer> result = new ArrayList<>();
        int i = currentWord.indexOf(guess);
        result.add(i);
        while (i >= 0) {
            i = currentWord.indexOf(guess, i + 1);
            result.add(i);
        }
        return result;
    }

    public int getLives() {
        return lives;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getWord() {
        return gameWord.getWord();
    }
}
