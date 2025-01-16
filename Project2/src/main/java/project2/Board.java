package project2;

public class Board {
    protected char[][] grid;
    protected int size;

    // constructor initializes grid
    public Board() {
        size = 3;
        grid = new char[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                grid[i][j] = '-';
            }
        }
    }

    // print grid
    public void display() {
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
    
    // returns true if successfully places symbol at location
    public boolean placeSymbol(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    // returns true if win condition satisfied
    public boolean checkWin(char symbol) {
        // check horizontal and vertical lines
        for (int i=0; i<3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol ||
                grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                return true;
            }
        }

        // check diagonals
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol ||
                grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    // returns true if no empty grid cells
    public boolean checkDraw() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    // returns true if location is within bounds and non-empty cell
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == '-';
    }

    // markers used by smart computer player for logic
    public void placeMarker(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }
    public void removeMarker(int row, int col) {
        grid[row][col] = '-';
    }

    // resets grid to '-' (empty) cells
    public void reset() {
        grid = new char[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    // returns other symbol on grid, or same symbol if no other symbols
    public char findOpponentSymbol(char symbol) {
        for (char[] row : grid) {
            for (char cell : row) {
                // find non-empty cell that is not the given symbol
                if (cell != symbol && cell != '-') { 
                    return cell;
                }
            }
        }

        // return given symbol
        return symbol;
    }

    public int getSize() {
        return size;
    }
}
