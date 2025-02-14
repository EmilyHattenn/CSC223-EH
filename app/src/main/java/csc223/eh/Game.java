package csc223.eh;
import java.util.Scanner;

public interface Game {
    
    public void startGame();
    public void printBoard();
    public void takeTurn(Scanner input);
    public boolean isGameOver();
    public void endGame();
    public void playGame();
}