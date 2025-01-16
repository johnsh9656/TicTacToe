package project1;

public class Main {
    public static void main(String[] args) {
        Player p1 = new HumanPlayer('X');
        Player p2 = new SmartComputerPlayer('O');

        Game game = new Game(p1, p2);
        game.play();
    }
}
