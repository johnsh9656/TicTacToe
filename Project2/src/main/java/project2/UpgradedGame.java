package project2;

import java.util.Scanner;

public class UpgradedGame extends Game {
    
    public UpgradedGame(Player player1, Player player2) {
        super(player1, player2);

        int gridSize = promptForInt("Enter grid size (N): ", 3, 20);
        int winLength = promptForInt("Enter winning line length (M): ", 3, gridSize);
    
        this.board = new UpgradedBoard(gridSize, winLength);
    }

    // continue to output prompt until user inputs int between lower and upper bounds
    private int promptForInt(String prompt, int lower, int upper) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;

        // keep prompting for move until valid input
        while (true) {
            System.out.print(prompt);
            try {
                num = scanner.nextInt();
                if (num >= lower && num <= upper) return num;
                else {
                    System.out.println("Input must be between "+lower+" and "+upper);
                }
            } catch (Exception ignored) {
                scanner.nextLine();
            }
            System.out.println("Invalid input. Try again.");
        }
    }
}
