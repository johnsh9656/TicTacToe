package project2;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(char symbol) {
        super(symbol);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int[] makeMove(Board board) {
        int row, col;
        
        // keep prompting for move until valid input
        while (true) {
            System.out.print("Enter your move as row and column (ex 2 3): ");
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 2) {
                try {
                    // user input is range {1, 2, 3}, adjusted to {0, 1, 2}
                    row = Integer.parseInt(input[0]) - 1;
                    col = Integer.parseInt(input[1]) - 1;
                    if (board.isValidMove(row, col)) {
                        return new int[]{row, col};
                    }
                } catch (Exception ignored) {
                    // if exception occurs, just continue loop
                }
            }
            System.out.println("Invalid input. Try again.");
        }
    }
}
