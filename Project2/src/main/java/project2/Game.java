package project2;

import java.util.Scanner;

public class Game {
    protected Board board;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game(Player player1, Player player2) {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.scanner = new Scanner(System.in);
    }

    // start game and manage play again loop
    public void play() {
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            playAgain = promptRestart();
            if (playAgain) board.reset();
        }
    }

    // main game logic
    private void playGame() {
        // player 1 always starts
        Player currentPlayer = player1;
        boolean gameOver = false;
        
        board.display();
        // repeat alternating moves until game ends
        while (!gameOver) {
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn:");

            // dynamic dispatch for player move
            int[] move = currentPlayer.makeMove(board);

            // attempt to make player move
            if (board.placeSymbol(move[0], move[1], currentPlayer.getSymbol())) {
                board.display();
                if (board.checkWin(currentPlayer.getSymbol())) {    // player wins
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    gameOver = true;
                } else if (board.checkDraw()) {     // draw
                    System.out.println("Draw!");
                    gameOver = true;
                } else {    // alternate to other player's move
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

    }

    // return true if player chooses to play again
    private boolean promptRestart() {
        System.out.print("Play again? (y/n): ");
        String input = scanner.nextLine().toLowerCase();
        return input.equals("y");
    }
}
