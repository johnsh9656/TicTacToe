package project1;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer(char symbol) {
        super(symbol);
        this.random = new Random();
    }

    @Override
    public int[] makeMove(Board board) {
        int row, col;
        // generate random cell location, regenerate until valid
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isValidMove(row, col));

        System.out.println("Computer chose: ("+(row+1)+", "+(col+1)+")");
        return new int[]{row, col};
    }
}
