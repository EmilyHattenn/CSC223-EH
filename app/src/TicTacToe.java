import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    
    // Attributes
    private char[][] board;
    private char player;
    private Scanner input;
    private Random random;

    // Constructor
    public TicTacToe() {
        board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}}; 
        player = 'X';
        input = new Scanner(System.in);
        random = new Random(); // Initialize random generator
    }  

    public void startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("You will be X and the computer will be O");
        System.out.println("Good luck!");
        printBoard();
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for (char[] row : board) {
            System.out.println("| " + row[0] + " | " + row[1] + " | " + row[2] + " |");
        }
        System.out.println();
    }

    public void takeTurn() {
        if (player == 'X') {
            // Human Player Move
            int row, col;
            while (true) {
                System.out.print("Enter row (0-2) and column (0-2): ");
                row = input.nextInt();
                col = input.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        break;
                    } else {
                        System.out.println("Cell already occupied! Try again.");
                    }
                } else {
                    System.out.println("Invalid input! Row and column must be between 0 and 2.");
                }
            }
            board[row][col] = 'X';
            player = 'O'; // Switch turn to computer
        } else {
            // Computer Move (Random)
            System.out.println("Computer's turn...");
            int row, col;
            while (true) {
                row = random.nextInt(3); // Random row (0-2)
                col = random.nextInt(3); // Random col (0-2)
                if (board[row][col] == ' ') {
                    board[row][col] = 'O';
                    break;
                }
            }
            player = 'X'; // Switch turn back to human
        }
    }

    public boolean isGameOver() {
        // Check rows
        for (char[] row : board) {
            if (row[0] != ' ' && row[0] == row[1] && row[1] == row[2]) return true;
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) return true;
        }

        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;

        // Check for a draw (if all cells are filled)
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false; // If any cell is empty, the game is not over
            }
        }
        
        return true; // If no winner and no empty cells, it's a draw
    }

    public void endGame() {
        printBoard();
        
        char winner = ' ';

        // Check rows
        for (char[] row : board) {
            if (row[0] != ' ' && row[0] == row[1] && row[1] == row[2]) {
                winner = row[0];
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                winner = board[0][col];
            }
        }

        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0];
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2];
        }

        if (winner != ' ') {
            System.out.println("Congratulations! Player " + winner + " wins!");
        } else {
            System.out.println("Game over! It's a draw.");
        }
    }

    public void playGame() {
        startGame();
        while (!isGameOver()) {
            takeTurn();
            printBoard();
        }
        endGame();
        input.close();
    }

    // Main method to run the game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
