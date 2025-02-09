package pl.edu.agh.hangman;

import java.util.HashSet;
import java.util.Set;

//Przechowuje stan gry, zgadywane litery, liczbę prób, wygrane/przegrane.
public class GameState {
    private final String word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int attemptsLeft = 6;

    public GameState(String word) {
        this.word = word;
    }

    public boolean isGameOver() {
        boolean gameOver = attemptsLeft == 0 || getMaskedWord().indexOf("_") == -1;
        if (gameOver) {
            System.out.println("Gra zakończona: " + (attemptsLeft == 0 ? "przegrałeś" : "wygrałeś"));
        }
        return gameOver;
    }


    public void processGuess(char guess) {
        if (!word.contains(String.valueOf(guess))) {
            attemptsLeft--;
        }
        guessedLetters.add(guess);
    }

    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            maskedWord.append(guessedLetters.contains(c) ? c : '_');
            maskedWord.append(' ');
        }
        return maskedWord.toString().trim();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getWord() {
        return word;
    }
}
