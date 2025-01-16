package project2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer('X');
        Player player2 = new SmartComputerPlayer('O');

        UpgradedGame game = new UpgradedGame(player1, player2);
        game.play();
    }
}
