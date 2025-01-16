package project1;

public abstract class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    // abstract function for player turn
    public abstract int[] makeMove(Board board);
}
