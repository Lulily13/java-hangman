package pl.edu.agh.hangman;

//Klasa główna, która zarządza logiką gry i koordynuje inne komponenty.
public class HangmanGame {
    private final RandomWord randomWord;
    private final GameState gameState;
    private final HangmanDisplay hangmanDisplay;
    private final UserInput userInput;


    public HangmanGame() {
        randomWord = new RandomWord("slowa.txt");
        gameState = new GameState(randomWord.getRandomWord());
        hangmanDisplay = new HangmanDisplay();
        userInput = new UserInput();
    }

    public void start() {
        while (!gameState.isGameOver()) {
            hangmanDisplay.show(gameState);
            char guess = userInput.guess();
            gameState.processGuess(guess);
        }
        hangmanDisplay.showFinalResult(gameState);
    }

}
