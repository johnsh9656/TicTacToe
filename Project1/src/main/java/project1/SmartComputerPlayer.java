package project1;

import java.util.Random;

public class SmartComputerPlayer extends Player {
    public SmartComputerPlayer(char symbol) {
        super(symbol);
    }

    @Override
    public int[] makeMove(Board board) {
        int[] move;

        // 1. play winning move if exists
        move = findWinningMove(board, getSymbol());
        if (move != null) return move;

        // 2. block opponent win if possible
        char opponentSymbol = board.findOpponentSymbol(getSymbol());
        move = findWinningMove(board, opponentSymbol);
        if (move != null) return move;

        // 3. play center of board
        move = playCenter(board);
        if (move != null) return move;

        // 4. play corners
        move = findAvailableCorner(board);
        if (move != null) return move;

        // 5. random move
        return getRandomMove(board);
    }

    // returns location of winning move for given symbol or null
    private int[] findWinningMove(Board board, char symbol) {
        // iterate through each cell
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                // check if each cell could cause win for symbol
                if (board.isValidMove(row, col)) {
                    board.placeMarker(row, col, symbol); // temporarily place marker
                    if (board.checkWin(symbol)) {
                        board.removeMarker(row, col); // undo temporary move
                        return new int[]{row, col};
                    }
                    board.removeMarker(row, col); // undo temporary move
                }
            }
        }
        return null;
    }

    // check each corner of board, return valid corner or null
    private int[] findAvailableCorner(Board board) {
        int[][] corners = {{0, 0}, 
                            {0, board.getSize()-1}, 
                            {board.getSize()-1, 0}, 
                            {board.getSize()-1, board.getSize()-1}};
        for (int[] corner : corners) {
            if (board.isValidMove(corner[0], corner[1])) {
                return corner;
            }
        }
        return null;
    }

    public int[] playCenter(Board board) {
        if (board.isValidMove(board.getSize()/2, board.getSize()/2)) {
            return new int[]{board.getSize()/2, board.getSize()/2};
        }
        return null;
    }

    // return random (valid) move
    private int[] getRandomMove(Board board) {
        int row, col;
        Random random = new Random();
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isValidMove(row, col));
        return new int[]{row, col};
    }
}
