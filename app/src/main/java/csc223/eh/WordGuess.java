import java.util.Scanner;

public class WordGuess implements Game {
    
    // Attributes
    private final String word = "bride";
    private char[] guessedWord;
    private int maxWrongGuess = 5;
    private int attemptsLeft = 5;
    private boolean isGameWon = false;

    // Methods
    public WordGuess() {
        guessedWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = '_';
        }
    }  

    public void startGame() {
        System.out.println("Welcome to Word Guess!");
        System.out.println("Try to guess the word one letter at a time or the entire word.");
        System.out.println("You have " + maxWrongGuess + " wrong guesses allowed.");
        printBoard();
    
    }


    public void printBoard() {
        System.out.print("Word: ");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println("\nAttempts left: " + attemptsLeft);
    }


    public void takeTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Guess the letter or the Entire word:");
        String guess = input.nextLine().toLowerCase();

        if  (guess.length() == 1) {
            char guessedChar = guess.charAt(0);
            if (word.contains(guess)) {
                System.out.println(guessedChar + " is in the word!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guessedChar) {
                        guessedWord[i] = guessedChar; 
                    }
                }
            } else {
                System.out.println(guessedChar + " is not in the word.");
                attemptsLeft--;
            }
        } else if (guess.equals(word)) {
            isGameWon = true;
            guessedWord = word.toCharArray();
        } else {
            System.out.println("Wrong guess!");
            attemptsLeft--;
        }
    }

    // Checks if the game is over
    public boolean isGameOver() {
        boolean noAttemptsLeft = attemptsLeft == 0;
        boolean wordFullyGuessed = new String(guessedWord).equals(word);

        return noAttemptsLeft || wordFullyGuessed || isGameWon;
    }


    public void endGame() {
        if (isGameWon || new String(guessedWord).equals(word)) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Game over! The correct word was: " + word);
        }
    }

    public void playGame() {
        startGame();
        while (!isGameOver()) {
            takeTurn();
            printBoard();
        }
        endGame();
    }

    // Main method to run the game
    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.playGame();
    }
}