package csc223.eh;

import java.util.Scanner;

public class WordGuess implements Game {
    
    // Attributes
    private final String word = "bride";
    private final char[] guessedWord;
    private final int maxWrongGuess = 5;
    private int attemptsLeft = 5;
    private boolean isGameWon = false;

    
    // Constructor
    public WordGuess() {
        guessedWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = '_';
        }
    }  

    // Methods
    @Override
    public void startGame() {
        System.out.println("Welcome to Word Guess!");
        System.out.println("Try to guess the word one letter at a time or the entire word.");
        System.out.println("You have " + maxWrongGuess + " wrong guesses allowed.");
        printBoard();
    
    }


    @Override
    public void printBoard() {
        System.out.print("Word: ");
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println("\nAttempts left: " + attemptsLeft);
    }


    @Override
    public void takeTurn(Scanner input) {  // Pass Scanner as a parameter
        System.out.println("Guess the letter or the entire word:");
        String guess = input.nextLine().toLowerCase();

        if (guess.length() == 1) {
            char guessedChar = guess.charAt(0);
            if (word.contains(String.valueOf(guessedChar))) {
                System.out.println(guessedChar + " is in the word!");
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guessedChar) {
                        guessedWord[i] = guessedChar; 
                    }
                }
                // Check if the word is fully guessed
                if (new String(guessedWord).equals(word)) {
                    isGameWon = true;
                }
            } else {
                System.out.println(guessedChar + " is not in the word.");
                attemptsLeft--;
            }
        } else if (guess.equals(word)) {
            isGameWon = true;
            // Update the contents of guessedWord without reassigning it
            for (int i = 0; i < word.length(); i++) {
                guessedWord[i] = word.charAt(i);
            }
        } else {
            System.out.println("Wrong guess!");
            attemptsLeft--;
        }
    }

    // Checks if the game is over
    @Override
    public boolean isGameOver() {
        boolean noAttemptsLeft = attemptsLeft == 0;
        boolean wordFullyGuessed = new String(guessedWord).equals(word);

        return noAttemptsLeft || wordFullyGuessed || isGameWon;
    }


    @Override
    public void endGame() {
        if (isGameWon || new String(guessedWord).equals(word)) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Game over! The correct word was: " + word);
        }
    }

    @Override
    public void playGame() {
        try (Scanner input = new Scanner(System.in)) {  // Create a single Scanner instance
        startGame();
            while (!isGameOver()) {
                takeTurn(input);  // Pass the Scanner
                printBoard();
        }
        endGame();
    }
}


    // Main method to run the game
    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.playGame();  // Start the game
    }
    
}