package project2;

public class UpgradedBoard extends Board {
    private final int winLength;
    
    public UpgradedBoard(int size, int winLength) {
        this.size = size;
        this.winLength = winLength;

        super.grid = new char[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                super.grid[i][j] = '-';
            }
        }
    }

    // returns true if win condition satisfied
    @Override
    public boolean checkWin(char symbol) {
        return checkRows(symbol) 
            || checkColumns(symbol) 
            || checkDiagonals(symbol);
    }

    // check each row in the grid for winning condition
    private boolean checkRows(char symbol) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= size - winLength; col++) {
                boolean win = true;
                for (int offset = 0; offset < winLength; offset++) {
                    if (grid[row][col + offset] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    // check each column in the grid for winning condition
    private boolean checkColumns(char symbol) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row <= size - winLength; row++) {
                boolean win = true;
                for (int offset = 0; offset < winLength; offset++) {
                    if (grid[row + offset][col] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    // check entire grid for diagonals satisfying winning condition
    private boolean checkDiagonals(char symbol) {
        // check top-left to bottom-right diagonals
        for (int row = 0; row <= size - winLength; row++) {
            for (int col = 0; col <= size - winLength; col++) {
                boolean win = true;
                for (int offset = 0; offset < winLength; offset++) {
                    if (grid[row + offset][col + offset] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }

        // Check top-right to bottom-left diagonals
        for (int row = 0; row <= size - winLength; row++) {
            for (int col = winLength - 1; col < size; col++) {
                boolean win = true;
                for (int offset = 0; offset < winLength; offset++) {
                    if (grid[row + offset][col - offset] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }
}
